package programmers._1108_check2

import acmicpc.Solve

class _2 {
    companion object {
        var solve = object : Solve {
            var name = ""
            override fun solution() {
                var answer = 0
                var middle = (('A'.toInt() + 'Z'.toInt()) / 2).toChar()
                var changedIndex = arrayListOf<Int>()

                name.forEachIndexed { index, char ->
                    val value = Math.min(char - 'A', Math.abs('Z' - char + 1))
                    if (value != 0) changedIndex.add(index)

                    answer += value
                }

                var movement = 0

                if (answer != 0) {
                    movement = Math.min(changedIndex[changedIndex.lastIndex], 0 + name.length - Math.abs(changedIndex[0] - 0))
                    for (index in 0 until changedIndex.size - 1) {
                        movement = Math.min(changedIndex[index] + name.length - Math.abs(changedIndex[index + 1] - changedIndex[index]), movement)
                        movement = Math.min(
                                name.length - changedIndex[changedIndex.lastIndex - index] +
                                        (name.length - changedIndex[changedIndex.lastIndex - index] +
                                        changedIndex[changedIndex.lastIndex - index - 1])
                                , movement)
                    }
                }

                answer += movement

                System.out.println(answer)
            }

            override fun input() {
                // name = "JEROEN"
                // solution()
                // name = "JAN"
                // solution()
                // name = "ABAAABBBBBBB"
                // solution()
                name = "AAAZAAZA"
                solution()
                name = "AABAAAAAAAB"
                solution()
                name = "AAAAAAAA"
                solution()
                name = "ABBBBAAAAABAAA"
                solution()
                name = "AAABAAA"
                solution()
                name = "ABAAAAAAAAABB"
                solution()
                name = "AZAAAZ"
                solution()
                name = "ABABAAAAAAABA"
                solution()
            }

            override fun testSolve() {
                input()
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