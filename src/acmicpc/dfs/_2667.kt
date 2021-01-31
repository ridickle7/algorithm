package acmicpc.dfs

import acmicpc.Solve
import java.util.*

class _2667 {
    companion object {
        var N: Int = 0
        var strings = ArrayList<String>()
        lateinit var matrix: Array<IntArray>
        lateinit var visited: Array<BooleanArray>
        lateinit var answers: IntArray
        var dx = arrayOf(0, 0, -1, 1)
        var dy = arrayOf(-1, 1, 0, 0)

        var solve = object : Solve {
            override fun solution() {
                var count = 0
                for (x in 0 until N)
                    for (y in 0 until N) {
                        dfs(x, y, count)
                        count++
                    }

                var list = answers.filter { it != 0 }.toTypedArray().sortedArray()
                System.out.println(list.size)
                for(i in 0 until list.size)
                    System.out.println(list[i])
            }


            private fun dfs(x: Int, y: Int, count: Int) {
                if (x > -1 && x < N && y > -1 && y < N) {
                    if (!visited[x][y]) {
                        visited[x][y] = true

                        if (matrix[x][y] == 1) {
                            answers[count] += 1

                            for (i in 0..3) {
                                dfs(x + dx[i], y + dy[i], count)
                            }

                        }
                    }
                }
            }

            override fun input() {
                var scan = Scanner(System.`in`)
                N = scan.nextInt()
                answers = IntArray(N * N) { 0 }
                scan.nextLine()

                for (i in 0 until N) {
                    strings.add(scan.nextLine())
                }

                matrix = Array(N) { IntArray(N) }
                visited = Array(N) { BooleanArray(N) { false } }

                for (i in 0 until matrix.size) {
                    matrix[i] = stringToIntArray(strings[i])
                }
            }

            fun testInput() {
                N = 7
                answers = IntArray(N * N) { 0 }
                strings.addAll(
                        arrayOf("0110100",
                                "0110101",
                                "1110101",
                                "0000111",
                                "0100000",
                                "0111110",
                                "0111000"))

                matrix = Array(N) { IntArray(N) }
                visited = Array(N) { BooleanArray(N) { false } }

                for (i in 0 until matrix.size) {
                    matrix[i] = stringToIntArray(strings[i])
                }
            }

            override fun testSolve() {
                testInput()
                solution()
            }

            override fun solve() {
                input()
                solution()
            }

            fun stringToIntArray(s: String): IntArray {
                var list = ArrayList<Int>()
                s.forEach { char ->
                    list.add(char.toInt() - 48)
                }

                return list.toIntArray()
            }
        }

        @JvmStatic
        fun main(args: Array<String>) {
            solve.solve()
        }
    }
}