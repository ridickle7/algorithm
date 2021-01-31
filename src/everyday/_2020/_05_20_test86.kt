package everyday._2020

import everyday.Solve


/**
 * 문제
 * 정렬된 정수 배열과 수가 주어졌을 때, 배열에서 주어진 수의 이하최댓값(floor)과 이상최솟값(ceil)을 찾으시오.
 * 여기서 이하 최댓값은 주어진 수보다 작거나 주어진 수와 같은 수 중 가장 큰 수라고 정의하고,
 * 이상 최솟값은 주어진 수보다 크거나 주어진 수와 같은 수 중 가장 작은 수라고 정의합니다.
 *
 * Input: A = [1, 4, 6, 8, 9]
 * Number = 0 to 10
 *
 * Output:
 * 0    -> 이상최솟값 1, 이하최댓값 -1
 * 1    -> 이상최솟값 1, 이하최댓값 1
 * 2    -> 이상최솟값 4, 이하최댓값 1
 * 3    -> 이상최솟값 4, 이하최댓값 1
 * 4    -> 이상최솟값 4, 이하최댓값 4
 * 5    -> 이상최솟값 6, 이하최댓값 4
 * 6    -> 이상최솟값 6, 이하최댓값 6
 * 7    -> 이상최솟값 8, 이하최댓값 6
 * 8    -> 이상최솟값 8, 이하최댓값 8
 * 9    -> 이상최솟값 9, 이하최댓값 9
 * 10   -> 이상최솟값 -1, 이하최댓값 9
 *
 * 시작 : 12:20
 * 종료 : 12:50
 */
class _05_20_test86 {
    companion object {
        var solve = object : Solve {
            var floor: Int = Short.MIN_VALUE.toInt()
            var ceil: Int = Short.MAX_VALUE.toInt()

            var input: List<Int>? = null
            var input2: List<Int>? = null

            override fun testSolve() {
                input2?.forEach { target ->
                    floor = Short.MIN_VALUE.toInt()
                    ceil = Short.MAX_VALUE.toInt()

                    input?.forEach { value ->
                        floor = if (target - value >= 0 && target - value < target - floor) value else floor
                        ceil = if (value - target >= 0 && value - target < ceil - target) value else ceil
                    }

                    if (floor == Short.MIN_VALUE.toInt()) floor = -1
                    if (ceil == Short.MAX_VALUE.toInt()) ceil = -1

                    println("$target : $ceil, $floor")
                }
            }

            override fun input() {
                input = listOf(1, 4, 6, 8, 9)
                input2 = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            }

            override fun solution() {

            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            solve.input()
            solve.testSolve()
        }
    }
}