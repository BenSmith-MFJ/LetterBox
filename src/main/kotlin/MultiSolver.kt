import kotlin.system.measureTimeMillis

object MultiSolver {
    @JvmStatic
    fun main(args: Array<String>) {
        MultiSolver::class.java.classLoader.getResource("puzzles.txt")!!
            .let { url -> java.io.File(url.path) }.readLines()
            .forEach { puzzle ->
                println("Puzzle: $puzzle")
                val elapsed = measureTimeMillis { Solver.main(arrayOf(puzzle)) }
                println("solved in $elapsed ms")
                println()
            }
    }
}