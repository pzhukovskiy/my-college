package com.example.project.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.data.database.GroupEvent
import com.example.project.data.database.GroupState
import com.example.project.data.database.SortType
import com.example.project.data.database.dao.GroupDAO
import com.example.project.data.database.data.Item
import com.example.project.data.group.Group
import com.example.project.repository.group.GroupsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GroupsViewModel(
    private val groupsRepository: GroupsRepository,
    private val context: Context,
    private val dao: GroupDAO
) : ViewModel() {

    private val _sortType = MutableStateFlow(SortType.GROUP)
    private val _items = _sortType
        .flatMapConcat { sortType ->
            when(sortType) {
                SortType.GROUP -> dao.getGroupsOrderedByName()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(GroupState())
    val state = combine(_state, _sortType, _items) {state, sortType, items ->
        state.copy(
            groups = items,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), GroupState())

    fun onEvent(event: GroupEvent) {
        when(event) {
            is GroupEvent.SaveGroup -> {
                val name = state.value.Name
                val groupID = state.value.Group
                if(name.isBlank()) {
                    return
                }

                val group = Item(
                    Name = name,
                    Group = groupID
                )

                viewModelScope.launch {
                    dao.upsertGroup(group)
                }

                _state.update {it.copy(
                    isAddingGroup = true,
                    Name = "",
                )}
            }

            is GroupEvent.DeleteItem -> {
                viewModelScope.launch {
                    dao.deleteGroup(event.group)
                }
            }

            is GroupEvent.SetGroupName -> {
                _state.update {it.copy(
                    Name = event.Name
                )}
            }

            is GroupEvent.SetGroupId -> {
                _state.update {it.copy(
                    Group = event.Group
                )}
            }
            is GroupEvent.SortGroups -> {
                _sortType.value = event.sortType
            }
        }
    }

    private val _groups = mutableStateListOf<Group>()
    var errorMessage: String by mutableStateOf("")
    val groupList: List<Group>
        get() = _groups

    private var job: Job? = null

    private var _selectedGroupId by mutableStateOf<Int?>(null)
    val selectedGroupId: Int?
        get() = _selectedGroupId

    init {
        if (isConnected()) {
            fetchData()
        } else {
            errorMessage = "No internet connection"
        }
    }

    fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val activeNetwork =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

    fun fetchData() {
        job = viewModelScope.launch {
            try {
                groupsRepository.fetchGroups().collect {
                    _groups.clear()
                    _groups.addAll(it)
                }
            } catch (e: Exception) {
                errorMessage = "Error fetching: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }

    fun getGroups(): List<Group> {
        return groupList
    }
}