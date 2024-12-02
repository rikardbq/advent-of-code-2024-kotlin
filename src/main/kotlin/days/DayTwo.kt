package se.rikardbq.days

import kotlin.math.abs

class DayTwo(override val path: String) : AdventDay {

    private val input = super.getInputContent(this.path)

    private fun prepareInput(inputSplit: List<String>): List<List<Int>> {
        return inputSplit.map { item -> item.split(" ").map { e -> e.toInt() } }
    }

    private fun checkRowEntries(items: List<Int>, desc: Boolean = false): Boolean {
        var predicate = true
        for (i in items.indices) {
            val e = items[i]
            if (i < items.size - 1) {
                val next = items[i + 1]
                val dirCheck = if (desc) e > next else e < next
                val diff = abs(e - next)
                predicate = predicate && diff in 1..3 && dirCheck
            }
        }

        return predicate
    }

    private fun partOne(): Int {
        val inputs = prepareInput(this.input.trim().split("\n"))
        val res = inputs.filter { item ->
            checkRowEntries(item) || checkRowEntries(
                item,
                true
            )
        }

        return res.size
    }

    private fun partTwo(): Int {
        val inputs = prepareInput(this.input.trim().split("\n"))
        val res = inputs.filter { item ->
            var predicate = true
            for (i in item.indices) {
                val subList1 = item.slice(0..<item.size - (i + 1))
                val subList2 = item.slice(item.size - i..<item.size)
                val withDampenerList = subList1.plus(subList2)

                predicate = checkRowEntries(withDampenerList) || checkRowEntries(
                    withDampenerList,
                    true
                )

                if (predicate) {
                    break
                }
            }

            predicate
        }

        return res.size
    }

    override fun run() {
        println("PART ONE: ${this.partOne()}")
        println("PART TWO: ${this.partTwo()}")
    }
}
