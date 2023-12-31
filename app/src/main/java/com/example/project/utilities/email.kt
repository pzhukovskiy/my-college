package com.example.project.utilities

sealed class EmailText(val text: String) {
//    object MailAddress : EmailText("mgke@minskedu.gov.by")
object MailAddress : EmailText("test_test@mail.test")
    object MailSubject : EmailText("Тема письма")
    object MailTextMorning : EmailText("Доброе утро, это текст сообщения, измените его")
    object MailTextDay : EmailText("Добрый день, это текст сообщения, измените его")
    object MailTextEvening : EmailText("Добрый вечер, это текст сообщения, измените его")
    object MailTextNight : EmailText("Доброй ночи, это текст сообщения, измените его")
}