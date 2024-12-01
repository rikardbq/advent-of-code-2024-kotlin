package se.rikardbq

import java.io.File
import java.io.InputStream

fun main() {
    println("******************************")
    println("**** Advent of Code 2024! ****")
    println("******************************")

    val day1 = DayOne("./assets/day1_input.txt")
    println("\n********** Day 1 *************")
    println("******************************")
    println(day1.run())
}