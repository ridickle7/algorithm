package everyday._2020

import everyday.Solve

/**
 * 정수 배열이 주어졌을 때, 퀵 정렬(quicksort) 알고리즘을 이용해 배열을 정렬하시오.
 *
 * Input: [9, -3, 5, 2, 6, 8, -6, 1, 3]
 * Output: [-6, -3, 1, 2, 3, 5, 6, 8, 9]
 *
 */

class _06_14_test89 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solve.input()
        }

        var input = mutableListOf<Int>()
        var pivot = -1
        var output: Int? = null

        val solve = object : Solve {
            override fun testSolve() {
                quickSort(0, input.size - 1)
            }

            fun quickSort(start: Int, end: Int) {
                if (start > end) return

                // pivot 을 정한다
                val pivot = start
                var left = pivot + 1
                var right = end

                while (left < right) {
                    // 왼쪽에서부터 pivot보다 크거나 같은 값을 찾는다.
                    while (left <= end) {
                        if (input[left] < input[pivot]) left++
                        else break
                    }

                    // 오른쪽에서부터 pivot보다 작은 값을 찾는다.
                    while (right >= start) {
                        if (input[right] > input[pivot]) right--
                        else break
                    }

                    // 바꿀값이 아직 남아있다면 바꾼다.
                    if (left <= right)
                        swap(left, right)
                    // 없다면 right 을 기준으로 바꾼다 (left 는 indexOutOfBoundException 발생 가능)
                    else
                        swap(pivot, right)
                }

                // 새로운 pivot 을 기준으로 quick Sort 수행
                quickSort(start, right - 1)
                quickSort(right + 1, end)
            }

            fun swap(a: Int, b: Int) {
                val temp = input[a]
                input[a] = input[b]
                input[b] = temp
            }

            override fun input() {
                input = mutableListOf(9, -3, 5, 2, 6, 8, -6, 1, 3)
                testSolve()
                print("")
            }

            override fun solution() {

            }
        }
    }
}