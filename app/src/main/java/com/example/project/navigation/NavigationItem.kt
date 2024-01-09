package com.example.project.navigation

sealed class NavigationItem(val route: String) {
    object Homepage : NavigationItem("Homepage")//HomepageScreen
    object DetailNews : NavigationItem("DetailNews")//DetailNewsScreen
    object ListAllNews : NavigationItem("ListAllNews")//ListAllNews
    object ListAllLinks : NavigationItem("ListAllLinks")//ListAllLinksScreen
    object SettingsPage : NavigationItem("SettingsPage")//SettingsPageScreen
    object RegistrationPage : NavigationItem("RegistrationPage")//RegistrationPageScreen
    object Profile : NavigationItem("ProfilePage")//ProfilePageScreen
    object AboutCollege : NavigationItem("AboutCollege")//AboutCollegeScreen
    object ListAdministration : NavigationItem("ListAdministration")//ListAdministrationScreen
    object DetailAdministration : NavigationItem("DetailAdministration")//DetailAdministrationScreen
    object ContactsPage : NavigationItem("ContactsPage")//ContactsPageScreen
    object ListTeachers : NavigationItem("ListTeachers")//TeachersScreen
    object DetailTeacher : NavigationItem("DetailTeacher")//DetailTeacherScreen
}