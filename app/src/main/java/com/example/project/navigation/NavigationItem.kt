package com.example.project.navigation

sealed class NavigationItem(val route: String) {
    object Homepage : NavigationItem("Homepage")//HomepageScreen
    object DetailNews : NavigationItem("DetailNews")//DetailNewsScreen
    object ListAllNews : NavigationItem("ListAllNews")//ListAllNews
    object ListAllLinks : NavigationItem("ListAllLinks")//ListAllLinksScreen
    object RegistrationPage : NavigationItem("RegistrationPage")//RegistrationPageScreen
    object Profile : NavigationItem("ProfilePage")//ProfilePageScreen
    object AdministratorWebView : NavigationItem("AdministratorWebView")//AdministratorWebViewScreen
    object AboutCollege : NavigationItem("AboutCollege")//AboutCollegeScreen
    object ListAdministration : NavigationItem("ListAdministration")//ListAdministrationScreen
    object DetailAdministration : NavigationItem("DetailAdministration")//DetailAdministrationScreen
    object ContactsPage : NavigationItem("ContactsPage")//ContactsPageScreen
    object ListEmployees : NavigationItem("ListEmployees")//ListEmployees
    object DetailEmployees : NavigationItem("DetailEmployees")//DetailEmployees
    object ListEmployeesAHCH : NavigationItem("ListEmployeesAHCH")//ListEmployees
    object DetailEmployeesAHCH : NavigationItem("DetailEmployeesAHCH")//DetailEmployees
    object ListTeachers : NavigationItem("ListTeachers")//TeachersScreen
    object DetailTeacher : NavigationItem("DetailTeacher")//DetailTeacherScreen
    object LessonsScreenDayGroup : NavigationItem("LessonsDayGroup")//LessonsScreenDayGroup
    object LessonsScreenDayTeacher : NavigationItem("LessonsDayTeacher")//LessonsScreenDayTeacher
    object LessonsScreenWeekGroup : NavigationItem("LessonsWeekGroup")//LessonsScreenWeekGroup
    object LessonsScreenWeekTeacher : NavigationItem("LessonsWeekTeacher")//LessonsScreenWeekTeacher
    object ScheduleTime : NavigationItem("ScheduleTime")//ScheduleTimeScreen
    object Info1966 : NavigationItem("1966")//Info1966
    object Info1967 : NavigationItem("1967")//Info1967
    object Info1969 : NavigationItem("1969")//Info1969
    object Info1970 : NavigationItem("1970")//Info1970
    object Info1971 : NavigationItem("1971")//Info1971
    object Info1974 : NavigationItem("1974")//Info1974
    object Info1980 : NavigationItem("1980")//Info1980
    object Info1990 : NavigationItem("1990")//Info1990
    object Info2000 : NavigationItem("2000")//Info2000
    object Info2010 : NavigationItem("2010")//Info2010
    object Info2020 : NavigationItem("2020")//Info2020
    object Info2021 : NavigationItem("2021")//Info2021
    object Info2022 : NavigationItem("2022")//Info2022
    object Info2023 : NavigationItem("2023")//Info2023
    object Info2024 : NavigationItem("2024")//Info2024
}