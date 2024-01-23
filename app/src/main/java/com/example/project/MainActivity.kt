package com.example.project

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.project.auth.GoogleAuthUiClient
import com.example.project.auth.SignInViewModel
import com.example.project.compose.screens.about_college.AboutCollegeScreen
import com.example.project.compose.screens.about_college.year_1966.Year1966
import com.example.project.compose.screens.about_college.year_1967.Year1967
import com.example.project.compose.screens.about_college.year_1969.Year1969
import com.example.project.compose.screens.about_college.year_1970.Year1970
import com.example.project.compose.screens.about_college.year_1971.Year1971
import com.example.project.compose.screens.administration.DetailAdministrationScreen
import com.example.project.compose.screens.administration.AdministrationScreen
import com.example.project.compose.screens.contacts.ContactsPageScreen
import com.example.project.compose.screens.employees.DetailEmployeeScreen
import com.example.project.compose.screens.employees.EmployeeScreen
import com.example.project.compose.screens.employeesAHCH.DetailEmployeeAhchScreen
import com.example.project.compose.screens.employeesAHCH.EmployeeAhchScreen
import com.example.project.compose.screens.home_page.HomepageScreen
import com.example.project.compose.screens.lessons.group.LessonsScreenDayForGroup
import com.example.project.compose.screens.lessons.group.LessonsScreenWeekForGroup
import com.example.project.compose.screens.lessons.teacher.LessonsScreenDayForTeacher
import com.example.project.compose.screens.lessons.teacher.LessonsScreenWeekForTeacher
import com.example.project.compose.screens.links.ListAllLinksScreen
import com.example.project.compose.screens.news.DetailNewsScreen
import com.example.project.compose.screens.news.ListAllNewsScreen
import com.example.project.compose.screens.profile.AdminWebViewScreen
import com.example.project.compose.screens.profile.ProfilePageScreen
import com.example.project.compose.screens.registration.RegistrationPageScreen
import com.example.project.compose.screens.schedule_time.ScheduleTimeScreen
import com.example.project.compose.screens.teachers.DetailTeacherScreen
import com.example.project.compose.screens.teachers.TeacherScreen
import com.example.project.data.database.GroupDatabase
import com.example.project.helper.ConnectionStatus
import com.example.project.helper.currentConnectivityStatus
import com.example.project.helper.observeConnectivityAsFlow
import com.example.project.navigation.NavigationItem
import com.example.project.repository.administration.AdministratorRepositoryImplementation
import com.example.project.repository.employee.EmployeeRepositoryImplementation
import com.example.project.repository.employeeAHCH.EmployeeRepositoryImplementationAHCH
import com.example.project.repository.group.GroupsRepositoryImplementation
import com.example.project.repository.lessons.LessonsRepositoryImplementation
import com.example.project.repository.news.NewsRepositoryImplementation
import com.example.project.repository.teachers.TeacherRepositoryImplementation
import com.example.project.ui.theme.ProjectTheme
import com.example.project.viewmodels.AdministratorViewModel
import com.example.project.viewmodels.EmployeesAhchViewModel
import com.example.project.viewmodels.EmployeesViewModel
import com.example.project.viewmodels.GroupsViewModel
import com.example.project.viewmodels.LessonsViewModel
import com.example.project.viewmodels.NewsViewModel
import com.example.project.viewmodels.SharedViewModel
import com.example.project.viewmodels.TeacherViewModel
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            GroupDatabase::class.java,
            "groups.db"
        ).build()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            @Composable
            fun connectivityStatus(): State<ConnectionStatus> {
                val context = LocalContext.current

                return produceState(initialValue = context.currentConnectivityStatus) {
                    context.observeConnectivityAsFlow().collect {value = it}
                }
            }

            val navController: NavHostController = rememberNavController()

            val connection by connectivityStatus()
            val isConnected = connection === ConnectionStatus.Available

            val sharedViewModel: SharedViewModel = viewModel()

            val groupViewModel = GroupsViewModel(GroupsRepositoryImplementation(), applicationContext, db.dao)
            val groupState by groupViewModel.state.collectAsState()

            ProjectTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavigationItem.RegistrationPage.route
                ) {

                    val teacherViewModel = TeacherViewModel(TeacherRepositoryImplementation(), applicationContext)
                    val administratorViewModel = AdministratorViewModel(AdministratorRepositoryImplementation(), applicationContext)
                    val newsViewModel = NewsViewModel(NewsRepositoryImplementation(), applicationContext)
                    val lessonsViewModel = LessonsViewModel(LessonsRepositoryImplementation(), applicationContext)
                    val employeesViewModel = EmployeesViewModel(EmployeeRepositoryImplementation(), applicationContext)
                    val employeesAhchViewModel = EmployeesAhchViewModel(EmployeeRepositoryImplementationAHCH(), applicationContext)

                    //homepage
                    composable(NavigationItem.Homepage.route) {
                            HomepageScreen(
                                navController = navController,
                                newsViewModel = newsViewModel,
                                userData = googleAuthUiClient.getSignedInUser(),
                                viewModel = sharedViewModel,
                                db = db,
                                state = groupState
                            )
                    }

                    //information about news
                    composable("${NavigationItem.DetailNews.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = newsViewModel.newsList.find { it.id == itemID }
                        selectedItem?.let {
                            DetailNewsScreen(
                                news = it,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    //lessons day for group
                    composable(NavigationItem.LessonsScreenDayGroup.route) {
                        LessonsScreenDayForGroup(
                            lessonsViewModel = lessonsViewModel,
                            viewModel = sharedViewModel,
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //lessons day for teacher
                    composable(NavigationItem.LessonsScreenDayTeacher.route) {
                        LessonsScreenDayForTeacher(
                            lessonsViewModel = lessonsViewModel,
                            viewModel = sharedViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //lessons week for group
                    composable(NavigationItem.LessonsScreenWeekGroup.route) {
                        LessonsScreenWeekForGroup(
                            lessonsViewModel = lessonsViewModel,
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //lessons week for teacher
                    composable(NavigationItem.LessonsScreenWeekTeacher.route) {
                        LessonsScreenWeekForTeacher(
                            lessonsViewModel = lessonsViewModel,
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //list all news
                    composable(NavigationItem.ListAllNews.route) {
                        ListAllNewsScreen(
                            viewModel = newsViewModel,
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //list all links
                    composable(NavigationItem.ListAllLinks.route) {
                        ListAllLinksScreen(
                            context = LocalContext.current,
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //registration page
                    composable(NavigationItem.RegistrationPage.route) {
                        val viewModel = viewModel<SignInViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle()

                        LaunchedEffect(key1 = Unit) {
                            if (googleAuthUiClient.getSignedInUser() != null) {
                                navController.navigate(NavigationItem.Homepage.route)
                            }
                        }

                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult(),
                            onResult = { result ->
                                if (result.resultCode == RESULT_OK) {
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = result.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                                }
                            }
                        )

                        LaunchedEffect(key1 = state.isSignInSuccessful) {
                            if (state.isSignInSuccessful) {
                                Toast.makeText(applicationContext, "Успешный вход", Toast.LENGTH_LONG).show()
                                navController.navigate(NavigationItem.Homepage.route)
                                viewModel.resetState()
                            }
                        }

                        RegistrationPageScreen(
                            state = state,
                            onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            }
                        )
                    }

                    //profile
                    composable(NavigationItem.Profile.route) {
                        ProfilePageScreen(
                            userData = googleAuthUiClient.getSignedInUser(),
                            onSignOut = {
                                lifecycleScope.launch {
                                    googleAuthUiClient.signOut()
                                    Toast.makeText(applicationContext, "Успешный выход", Toast.LENGTH_LONG).show()
                                    navController.navigate(NavigationItem.RegistrationPage.route)
                                }
                            },
                            navController = navController,
                            db = db,
                            state = groupState,
                            onEvent = groupViewModel::onEvent,
                            viewModel = sharedViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //administrator web-view
                    composable(NavigationItem.AdministratorWebView.route) {
                        AdminWebViewScreen()
                    }

                    //about college
                    composable(NavigationItem.AboutCollege.route) {
                        AboutCollegeScreen(
                            navController = navController,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //list all administration
                    composable(NavigationItem.ListAdministration.route) {
                        AdministrationScreen(
                            navController = navController,
                            viewModel = administratorViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //information about administrator
                    composable("${NavigationItem.DetailAdministration.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = administratorViewModel.administratorList.find { it.id == itemID }
                        selectedItem?.let {
                            DetailAdministrationScreen(
                                administrator = it,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    //list all teachers
                    composable(NavigationItem.ListTeachers.route) {
                        TeacherScreen(
                            navController = navController,
                            viewModel = teacherViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //information about teacher
                    composable("${NavigationItem.DetailTeacher.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = teacherViewModel.teachersList.find { it.id == itemID }
                        selectedItem?.let {
                            DetailTeacherScreen(
                                teacher = it,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    //list all employees
                    composable(NavigationItem.ListEmployees.route) {
                        EmployeeScreen(
                            navController = navController,
                            viewModel = employeesViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //information about employee
                    composable("${NavigationItem.DetailEmployees.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = employeesViewModel.employeeList.find { it.id == itemID }
                        selectedItem?.let {
                            DetailEmployeeScreen(
                                employee = it,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    //list all employees ahch
                    composable(NavigationItem.ListEmployeesAHCH.route) {
                        EmployeeAhchScreen(
                            navController = navController,
                            viewModel = employeesAhchViewModel,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //information about employee ahch
                    composable("${NavigationItem.DetailEmployeesAHCH.route}/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val itemID = backStackEntry.arguments?.getInt("id")
                        val selectedItem = employeesAhchViewModel.employeeAhchList.find { it.id == itemID }
                        selectedItem?.let {
                            DetailEmployeeAhchScreen(
                                employeeAhch = it,
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }

                    //contacts
                    composable(NavigationItem.ContactsPage.route) {
                        ContactsPageScreen(
                            context = LocalContext.current,
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //schedule time
                    composable(NavigationItem.ScheduleTime.route) {
                        ScheduleTimeScreen(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //1966
                    composable(NavigationItem.Info1966.route) {
                        Year1966(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //1967
                    composable(NavigationItem.Info1967.route) {
                        Year1967(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //1969
                    composable(NavigationItem.Info1969.route) {
                        Year1969(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //1970
                    composable(NavigationItem.Info1970.route) {
                        Year1970(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }

                    //1971
                    composable(NavigationItem.Info1971.route) {
                        Year1971(
                            onBackClick = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}