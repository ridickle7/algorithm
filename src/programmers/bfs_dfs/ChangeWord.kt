package programmers.bfs_dfs

import java.util.LinkedList

// 16:59 시작
class ChangeWord {
    companion object {
        // 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
        // 2. words에 있는 단어로만 변환할 수 있습니다.

        @JvmStatic
        fun main(args: Array<String>) {
            solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log"))
        }

        fun solution(begin: String, target: String, words: Array<String>): Int {
            var answer = 0

            var wordList = arrayListOf<String>().apply {
                for (i in 0 until words.size)
                    add(words[i])
            }

            answer = recursion(begin, target, wordList, 0)
            return answer
        }

        private fun recursion(begin: String, target: String, wordList: ArrayList<String>, stack: Int): Int {
            if (wordList.indexOf(target) < 0)
                return 0
            else {
                var tempBegin = begin
                var tempTarget = target
                var tempWordList = wordList
                var tempStack = stack

                var beginList = tempBegin.toCharArray()
                var targetList = tempTarget.toCharArray()
                var check = beginList.size - 1

                for (i in 0 until wordList.size) {
                    var count = 0
                    var targetCount = 0
                    var compare = wordList[i].toCharArray()
                    for (j in 0 until beginList.size) {
                        if (beginList[j] == compare[j])
                            count++

                        if (beginList[j] == targetList[j])
                            targetCount++
                    }

                    if (targetCount == check) {
                        tempStack++
                        return tempStack
                    }

                    if (count == check) {
                        tempBegin = wordList[i]
                        tempStack++
                        tempWordList.removeAt(i)
                        return recursion(tempBegin, tempTarget, tempWordList, tempStack)
                    }
                }

                return 0
            }
        }
    }
}