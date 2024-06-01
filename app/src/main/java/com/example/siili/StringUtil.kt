package com.example.siili

object StringUtil {
    fun countdownNumberInSentence(sentence: String): String {
        // Use regular expression to find a number in the sentence
        val regex = Regex("\\d+")
        val matchResult = regex.find(sentence)

        return if (matchResult != null) {
            // Get the number as a string
            val numberStr = matchResult.value
            // Convert it to an integer
            val number = numberStr.toInt()
            // Decrement the number
            val newNumber = number - 1

            // Replace the old number with the new one in the sentence
            sentence.replaceFirst(numberStr, newNumber.toString())
        } else {
            // Return the original sentence if no number is found
            sentence
        }
    }
}