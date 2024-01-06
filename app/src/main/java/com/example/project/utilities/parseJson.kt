package com.example.project.utilities

import android.content.Context
import com.example.project.data.administration.AdministrationInfo
import com.example.project.data.news.NewsInfo
import com.google.gson.Gson
import java.io.IOException

fun getJson(
    context: Context,
    fileName: String
): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exception: IOException) {
        exception.printStackTrace()
        return null
    }

    return jsonString
}

fun parseListNews(context: Context, modelsToShow: String): List<NewsInfo> {
    val jsonFileString = getJson(context = context, "db.json")
    val newsList = Gson().fromJson(jsonFileString, Array<NewsInfo>::class.java).toList()

    return newsList.filter { it.model in modelsToShow }
}

fun parseListAdministration(context: Context, modelsToShow: String): List<AdministrationInfo> {
    val jsonFileString = getJson(context = context, "db.json")
    val administrationList = Gson().fromJson(jsonFileString, Array<AdministrationInfo>::class.java).toList()

    return administrationList.filter { it.model in modelsToShow }
}