package programmers._1108_check2

import acmicpc.Solve
import java.util.*

class _1 {
    companion object {
        var solve = object : Solve {
            var arrangement = ""
            override fun solution() {
                var lines: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
                var splits: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
                var queues: Stack<Int> = Stack()

                var stack = 0
                arrangement.forEachIndexed { index, char ->
                    when (char) {
                        '(' -> {
                            stack = 1
                            queues.add(index)
                        }
                        ')' -> {
                            // splits
                            var startIndex = queues.pop()

                            if (stack == 1) {
                                splits.add(Pair(startIndex, index))
                                stack = 0
                            } else {
                                lines.add(Pair(startIndex, index))
                            }
                        }
                    }
                }

                var answer = 0
                lines.forEach { line ->
                    var count = 1
                    splits.forEach { split ->
                        if (line.first < split.first && line.second > split.second)
                            count += 1
                    }
                    answer += count
                }

                System.out.println(answer)
            }

            override fun input() {
                arrangement = "()(((()())(())()))(())"

            }

            override fun testSolve() {
                input()
                solution()
            }

            override fun solve() {

            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            solve.testSolve()
        }
    }
}