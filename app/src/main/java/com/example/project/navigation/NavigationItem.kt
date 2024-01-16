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
    object LessonsScreenDayGroup : NavigationItem("LessonsDayGroup")//LessonsScreenDayGroup
    object LessonsScreenDayTeacher : NavigationItem("LessonsDayTeacher")//LessonsScreenDayTeacher
    object LessonsScreenWeekGroup : NavigationItem("LessonsWeekGroup")//LessonsScreenWeekGroup
    object LessonsScreenWeekTeacher : NavigationItem("LessonsWeekTeacher")//LessonsScreenWeekTeacher
    object Info1966 : NavigationItem("1966")//Info1966
    object Info1967 : NavigationItem("1967")//Info1967
    object Info1969 : NavigationItem("1969")//Info1969
    object Info1970 : NavigationItem("1970")//Info1970
    object Info1971 : NavigationItem("1971")//Info1971
    object Info1972 : NavigationItem("1972")//Info1972
    object Info1973 : NavigationItem("1973")//Info1973
    object Info1974 : NavigationItem("1974")//Info1974
    object Info1975 : NavigationItem("1975")//Info1975
    object Info1976 : NavigationItem("1976")//Info1976
    object Info1977 : NavigationItem("1977")//Info1977
    object Info1978 : NavigationItem("1978")//Info1978
    object Info1979 : NavigationItem("1979")//Info1979
    object Info1980 : NavigationItem("1980")//Info1980
    object Info1981 : NavigationItem("1981")//Info1981
    object Info1982 : NavigationItem("1982")//Info1982
}