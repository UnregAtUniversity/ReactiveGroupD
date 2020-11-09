package de.hawe.kotlin8

class MySequenz{
    var name = "Anne"
    fun sequenzenTest() {
        val words = "The quick brown fox jumps over the lazy dog".split(" ")
        //convert the List to a Sequence
        val wordsSequence = words.asSequence()
        val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
                .map { println("length: ${it.length}"); it.length }
                .take(4)
        println("Lengths of first 4 words longer than 3 chars")
// terminal operation: obtaining the result as a List
        println(lengthsSequence.toList())
    }
}



