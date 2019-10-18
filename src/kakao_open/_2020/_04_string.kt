package kakao_open._2020

class _04_string {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var words = arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao")
            var queries = arrayOf("fro??", "????o", "fr???", "fro???", "pro?")
            System.out.println(solution(words, queries))
        }

        fun solution(words: Array<String>, queries: Array<String>): IntArray {
            val answer = mutableListOf<Int>()

            // queries
            queries.forEach { query ->
                var equalNum = 0
                words.forEach { word ->
                    if(word.length == query.length){
                        val tempQuery = query.replace("?", "")

                        if(word.startsWith(tempQuery) || word.endsWith(tempQuery))
                            equalNum += 1
                    }
                }
                answer.add(equalNum)
                equalNum = 0
            }
            return answer.toIntArray()
        }
    }
}

