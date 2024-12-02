package se.rikardbq.days

import java.util.ArrayList
import kotlin.math.abs

class DayOne(override val path: String) : AdventDay {

    private val input = super.getInputContent(this.path)

    private fun prepareInput(inputSplit: List<String>): Pair<List<Int>, List<Int>> {
        val firstList = mutableListOf<Int>()
        val secondList = mutableListOf<Int>()

        inputSplit.forEach { item ->
            val (number1, number2) = item.split("\\s+".toRegex())

            firstList.add(number1.toInt())
            secondList.add(number2.toInt())
        }

        return Pair(firstList, secondList)
    }

    private fun partOne(): Int {
        val inputSplit = this.input.trim().split("\n")
        val (firstList, secondList) = prepareInput(inputSplit)
        val firstListSorted = firstList.sorted()
        val secondListSorted = secondList.sorted()
        val resultList = ArrayList<Int>()

        for (i in inputSplit.indices) {
            resultList.add(abs(firstListSorted[i] - secondListSorted[i]))
        }

        return resultList.sum()
    }

    private fun partTwo(): Int {
        val inputSplit = this.input.trim().split("\n")
        val (firstList, secondList) = prepareInput(inputSplit)
        val resultMap = HashMap<Int, Int>()

        for (i in secondList.indices) {
            val k = secondList[i]
            if (firstList.contains(k)) {
                resultMap[k] = (resultMap[k] ?: 0) + 1
            }
        }

        return resultMap.map { (k, v) -> k * v }.sum()
    }

    override fun run() {
        println("PART ONE: ${this.partOne()}")
        println("PART TWO: ${this.partTwo()}")
    }
}
