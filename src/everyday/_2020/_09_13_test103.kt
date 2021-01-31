package everyday._2020

import everyday.Solve

/**
 * N개의 원소들이 들어있는 M개의 정렬된 리스트가 주어졌을 때, 모든 원소를 정렬된 순서로 효율적으로 출력하시오.
 *
 * Input
 * [ 10, 20, 30, 40 ]
 * [ 15, 25, 35, 45 ]
 * [ 27, 29, 37, 48 ]
 * [ 32, 33, 39, 50 ]
 * [ 16, 18, 22, 28 ]
 *
 * Output: 10 15 16 18 20 22 25 27 28 29 30 32 33 35 37 39 40 45 48 50
 */
class _09_13_test103 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solve.input()
        }

        var input = listOf<Int>()
        var output: Int? = null

        val solve = object : Solve {
            override fun testSolve() {
                output = input.filter { it == 1 }.sum()
                println("$output")
            }

            override fun input() {
                input = listOf(0, 0, 0, 0, 1, 1, 1)
                testSolve()

                input = listOf(0, 0, 1, 1, 1, 1, 1)
                testSolve()
            }

            override fun solution() {

            }
        }
    }
}