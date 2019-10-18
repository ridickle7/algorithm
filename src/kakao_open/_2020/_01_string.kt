package kakao_open._2020

class _01_string {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.println(solution("abcabcabcabcdededededede"))
        }

        fun solution(s: String): Int {
            var answer = s.length
            var count = 0

            for (i in 1..(s.length / 2)) {
                var temp = s.length
                count++
                var enable = false

                var charTemp = s.substring(0, i)
                var j = i
                while (j + count - 1 < s.length) {
                    if (s.substring(j, j + count) == charTemp) {
                        temp -= count
                        if (!enable) {
                            temp++
                            enable = true
                        }
                    } else {
                        // 새로운 타겟을 지금 position 의 단어로 잡는다.
                        // j = if (enable) j else j - count + 1
                        charTemp = s.substring(j, j + count)
                        enable = false
                        // answer은 그대로 둔다 (그냥 다음으로 넘어가는 거니까)
                    }
                    j += count
                }

                answer = Math.min(answer, temp)
            }

            return answer
        }
    }
}

