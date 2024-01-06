package com.example.project.navigation

sealed class NavigationItem(val route: String) {
    object Homepage : NavigationItem("Homepage")//HomepageScreen
    object DetailNews : NavigationItem("DetailNews")//DetailNewsScreen
    object ListAllNews : NavigationItem("ListAllNews")//ListAllNews
    object ListAllLinks : NavigationItem("ListAllLinks")//ListAllLinksScreen
    object SettingsPage : NavigationItem("SettingsPage")//SettingsPageScreen
    object Profile : NavigationItem("ProfilePage")//ProfilePageScreen
    object AboutCollege : NavigationItem("AboutCollege")//AboutCollegeScreen
    object ListAdministration : NavigationItem("ListAdministration")//ListAdministrationScreen
    object DetailAdministration : NavigationItem("DetailAdministration")//DetailAdministrationScreen
}