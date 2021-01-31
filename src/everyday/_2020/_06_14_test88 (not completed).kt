package everyday._2020

import everyday.Solve

/**
 * 주어진 이진 트리를 전위 순회(pre-order)하는 코드를 작성하시오.
 * */

class `_06_14_test88 (not completed)` {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solve.input()
        }

        var input = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        var gotoRight = false
        var output: Int? = null

        val solve = object : Solve {
            override fun testSolve() {
                var count = input.size
                var pivot = 1

                while (count-- != 0) {
                    print(input[pivot - 1])
                    pivot = getPivot(prevPivot = pivot)
                }
            }

            fun getPivot(prevPivot: Int): Int {
                return when {
                    // 만약 왼쪽으로 더 갈 수 있는 상황이라면, 바로 그 값을 대입한다.
                    prevPivot * 2 <= input.size -> (prevPivot * 2).apply { gotoRight = false }
                    // 오른쪽으로 더 갈 수 있는 상황이라면, 바로 그 값을 대입한다.
                    prevPivot + 1 <= input.size && !gotoRight -> (prevPivot + 1).apply { gotoRight = true }
                    // 여의치 않을 시 2를 나누고 그 값을 + 1 한다.
                    else -> (prevPivot / 2 + 1).apply { gotoRight = false }
                }
            }

            override fun input() {
                input = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                testSolve()
            }

            override fun solution() {

            }
        }
    }
}