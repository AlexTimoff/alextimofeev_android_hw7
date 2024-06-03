package com.example.alextimofeev_android_hw7_.quiz

object QuizStorage {
    data class QuizQuestion(
        val text: String,
        val answer1: String,
        val answer2: String,
        val answer3: String,
        val answer4: String,
        val correctAnswer: Int
    )

    val quest1= QuizQuestion(
        "Сколько километров в одной миле?",
        "1,4 км",
        "1,6 км",
        "1,8 км",
        "1,9 км",
        2
    )

    val quest2= QuizQuestion(
        "Мюнхгаузен летал на ...?",
        "ядре",
        "метле",
        "воздушном шаре",
        "ковре",
        1
    )
    val quest3= QuizQuestion(
        "Что такое Измир?",
        "сладость",
        "страна",
        "город в Турции",
        "фрукт",
        3
    )
    val quest4= QuizQuestion(
        "На каком озере было Ледовое побоище?",
        "Рица",
        "Байкал",
        "Ладожское",
        "Чудское",
        4
    )

    fun createArray():ArrayList<QuizQuestion>{
        val questionnaireList=ArrayList<QuizQuestion>()
        return questionnaireList
    }


}