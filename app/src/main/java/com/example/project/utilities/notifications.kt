package com.example.project.utilities

sealed class NotificationsText(val text: String) {
    object Title : NotificationsText("Изменение расписания")
    object Text : NotificationsText("Просмотрите новое расписание")
}