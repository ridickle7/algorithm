package everyday._2020

import everyday.Solve

/**
 * 정렬된 바이너리 배열이 주어졌을 때, 효율적으로 1의 개수를 구하시오.
 *
 * Input: A = [0, 0, 0, 0, 1, 1, 1]
 * Output: 3
 *
 * Input: A = [0, 0, 1, 1, 1, 1, 1]
 * Output: 5
 *
 * */

class _06_14_test87 {
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