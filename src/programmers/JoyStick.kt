package programmers

class JoyStick {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.print(solution("JAZ"))
        }

        fun solution(name: String): Int {
            var answer = 0
            var changeStack = 0

            var countAMaximum = -1
            var firstAApplyed = name.length - 1
            var lastFlag = true
            var lastAApplyed = name.length

            var fixedAprevIndex = 0
            var fixedAnextIndex = 0
            val center = 'A' + (('Z' - 'A') / 2)

            for (i in 0 until name.length) {
                // 위치의 이동에 따른 값 control
                if (name[i] == 'A') {
                    var countA = 0
                    var countAprevIndex = i
                    var countAnextIndex = i
                    var nextIndex = i + 1
                    while (true) {
                        ++countA
                        if (nextIndex > name.length - 1) {
                            break
                        } else if (name[nextIndex] != 'A')
                            break
                        else {
                            countAnextIndex = nextIndex
                            nextIndex++
                        }
                    }

                    countAMaximum = if (countA > countAMaximum) {
                        countA.apply {
                            fixedAprevIndex = countAprevIndex
                            fixedAnextIndex = countAnextIndex
                        }
                    } else
                        countAMaximum

                    if (i == 0) {
                        firstAApplyed = name.length - 1 - countAnextIndex
                    } else if (lastFlag && nextIndex == name.length) {
                        lastAApplyed = countAprevIndex - 1
                        lastFlag = false
                    }
                }

                val temp = when {
                    name[i] - center < 0 -> name[i] - 'A'
                    else -> 'Z' - name[i] + 1
                }

                changeStack += temp
            }

            // 만약 index 0 이나 끝부터 시작하면
            if (fixedAprevIndex < 1 || fixedAnextIndex > name.length - 2) {
                return answer + changeStack + Math.min(firstAApplyed, lastAApplyed)
            } else {
                var first = fixedAprevIndex - 1
                var second = name.length - (fixedAnextIndex + 1)

                var number = Math.min(if (first < second) first * 2 + second else second * 2 + first, firstAApplyed)
                number = Math.min(number, lastAApplyed)
                return answer + changeStack + number
            }
        }
    }
}