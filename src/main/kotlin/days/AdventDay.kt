package se.rikardbq.days

import java.io.File
import java.io.InputStream

interface AdventDay {
    val path: String

    fun getInputContent(path: String): String {
        val inputStream: InputStream = File(path).inputStream()
        val inputString = inputStream.bufferedReader().use { it.readText() }

        return inputString
    }

    fun run()
}