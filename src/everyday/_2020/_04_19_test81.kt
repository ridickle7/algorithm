package everyday._2020

import everyday.Solve
import java.util.*

/**
 * 정렬된 정수 배열이 주어졌을 때, 주어진 수가 존재하는 배열의 첫 번째 위치와 마지막 위치를 찾으시오.
 * 배열에 찾는 수가 없다면 없다고 출력하세요.
 *
 * Input:
 * A = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
 * target = 5
 *
 * Output:
 * 첫 번째 위치는 인덱스 1
 * 마지막 위치는 인덱스 3
 *
 * Input:
 * A = [2, 5, 5, 5, 6, 6, 8, 9, 9, 9]
 * target = 4
 *
 * Output:
 * 찾는 값 없음
 * */

class _04_19_test81 {
    companion object {
        val solve = object : Solve {
            var list = listOf<Int>()
            var target: Int? = null

            var queue: Queue<Int> = LinkedList<Int>()
            var answer1 = -1
            var answer2 = -1

            override fun testSolve() {
                // 0 / 1 2 / 3 4 5 6 / 7 8 9 10
                queue.add(0)

                while (queue.size != 0) {
                    val pivot = queue.poll()

                    if (list[pivot] <= target!!) {
                        if (list[pivot] == target!!) {
                            if (answer1 != -1)
                                answer2 = pivot
                            else
                                answer1 = pivot
                        }

                        if (pivot * 2 + 1 < list.size - 1)
                            queue.add(pivot * 2 + 1)
                        if (pivot * 2 + 2 < list.size - 1)
                            queue.add(pivot * 2 + 2)
                    }
                }

                println("$answer1 / $answer2")
            }

            override fun input() {
                list = listOf(2, 5, 5, 5, 6, 6, 8, 9, 9, 9)
                target = 5
                testSolve()

                answer1 = -1
                answer2 = -1

                list = listOf(2, 5, 5, 5, 6, 6, 8, 9, 9, 9)
                target = 4
                testSolve()
            }

            override fun solution() {

            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            solve.input()
        }
    }
}