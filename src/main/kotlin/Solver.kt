object Solver {
    @JvmStatic
    fun main(args: Array<String>) {
        check(args.isNotEmpty() && """\w{3},\w{3},\w{3},\w{3}""".toRegex().matches(args[0])) {
            "First argument must be a puzzle (like rme,wcl,tgk,api)"
        }

        val box = args[0].split(",").flatMapIndexed { edgeId, edgeLetters ->
            edgeLetters.uppercase().map { letter -> letter to edgeId }
        }.toMap()

        fun String.isValidForThisBox() = this.length >= 3 && this.map { letter -> box[letter] }.windowed(2)
            .all { (first, second) -> first != null && second != null && first != second }

        val validWordsByFirstLetter = Solver::class.java.classLoader.getResource("words.txt")!!
            .readText().splitToSequence("\n").map { it.trim().uppercase() }
            .filter { word -> word.isValidForThisBox() }.groupBy { it.first() }

        validWordsByFirstLetter.values.flatten().forEach { firstWord ->
            validWordsByFirstLetter[firstWord.last()]
                ?.filter { secondWord -> (firstWord + secondWord).toSet().size >= 12 }
                ?.forEach { secondWord -> println("$firstWord,$secondWord") }
        }
    }
}