package programmers

import java.util.*

// 아니 처음에 왜 다 틀린거야...
// 1. Queue 사용할 떄는 LinkedList<Int> 로 선언해서 사용할 것
//      empty : 값이 비었는지 확인
//      add : stack의 push와 같은 의미
//      poll : stack의 pop과 같은 의미
//      peek : stack의 peek과 같은 의미 (단순히 값 불러오기)
//      remove :


class Develop {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))
        }

        fun solution(progresses: IntArray, speeds: IntArray): IntArray {
            val answer = arrayListOf<Int>()

            val workTimes: Queue<Int> = LinkedList<Int>()

            for (i in 0 until progresses.size)
                workTimes.add(Math.ceil((100 - progresses[i]) / speeds[i].toDouble()).toInt())

            var pivot = workTimes.poll()
            var stack = 1

            while (!workTimes.isEmpty()) {
                val workTime = workTimes.peek()

                // pivot이 worktime 보다 작을 경우 값 갱신
                if (pivot < workTime) {
                    answer.add(stack)
                    pivot = workTime
                    stack = 1
                }
                else{
                    stack++
                }

                workTimes.poll()
            }

            if (stack != 0)
                answer.add(stack)

            return answer.toIntArray()
        }
    }
}