package se.rikardbq

import se.rikardbq.days.*

fun main() {
    println("******************************")
    println("**** Advent of Code 2024! ****")
    println("******************************")

    val day1 = DayOne("./assets/day1_input.txt")
    println("\n********** Day 1 *************")
    println("******************************")
    println("${day1.run()}\n")

    val day2 = DayTwo("./assets/day2_input.txt")
    println("\n********** Day 2 *************")
    println("******************************")
    println("${day2.run()}\n")
}