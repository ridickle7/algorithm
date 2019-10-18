package programmers.bfs_dfs

// 16:59 시작
class ChangeWord_Temp {
    companion object {
        // 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        // 2. words에 있는 단어로만 변환할 수 있습니다.

        var isVisited = ArrayList<Boolean>()
        var newWords = ArrayList<String>()
        var connectsTable = ArrayList<ArrayList<Boolean>>()

        @JvmStatic
        fun main(args: Array<String>) {
            solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog"))
        }

        fun solution(begin: String, target: String, words: Array<String>): Int {
            var answer = 0
            // 만약 최종 단어가 words안에 없는 경우
            if (words.indexOf(target) == -1)
                return answer
            // 있는 경우
            else {
                // 초기화
                for (i in 0..words.size) {
                    isVisited.add(false)
                    newWords.add(if (i == 0) begin else words[i - 1])

                    connectsTable.add(arrayListOf())
                    for (j in 0..words.size) {
                        connectsTable[i].add(false)
                    }
                }

                // 간선 연결
                difference(0, 1, newWords)

                search(begin, target, words)
            }
            return answer
        }

        fun search(begin: String, target: String, words: Array<String>) {
            val (first, second) = arrayOf(words.indexOf(begin), words.indexOf(target))
            var answer = 0

            for(index in 0 until isVisited.size){


            }
        }

        fun difference(firstPosition: Int, secondPosition: Int, newWords: ArrayList<String>) {
            var stack = 0
            val (first, second) = arrayOf(newWords[firstPosition], newWords[secondPosition])

            for (index in 0 until first.length) {
                if (first[index] == second[index]) {
                    stack++
                }
            }

            if (stack == first.length - 1) {
                if (firstPosition > newWords.size - 1) {
                    return
                } else if (secondPosition > newWords.size - 1) {
                    difference(firstPosition + 1, firstPosition + 2, newWords)
                } else if (!connectsTable[firstPosition][secondPosition]) {
                    connectsTable[firstPosition][secondPosition] = true
                    connectsTable[secondPosition][firstPosition] = true
                    difference(firstPosition, secondPosition + 1, newWords)
                }
            }
        }
    }
}