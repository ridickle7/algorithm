package jobpair

class _02_palindrome {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.println(solution("123300"))
        }

        fun solution(n: String): Int {
            var answer = 0

            val aArray = n.toCharArray()
            aArray.sort()

            var trackingNum = '0'

            var trackingStack = 0
            var trackingCenter = false
            var trackingZero = 0
            var trackingOther = 0

            // 숫자는 0~9까지 밖에 존재하지 않음
            // 단 0의경우 트래킹을 해주어야 함 ex> 1000000 의 경우 010이 될 수 없기 때문에!
            var index = 0
            var size = aArray.size
            while (index != size) {
                if (aArray[index] == trackingNum) {
                    trackingStack += 1
                    index++
                } else {
                    trackingCenter = trackingStack % 2 == 1
                    when (trackingNum) {
                        '0' -> trackingZero += trackingStack / 2
                        else -> trackingOther += trackingStack / 2
                    }

                    // 초기화 (trackingStack, trackingNum)
                    trackingStack = 0
                    trackingNum = aArray[index]
                }
            }
            trackingOther += trackingStack / 2
            trackingCenter = trackingCenter || trackingStack != 0

            if (trackingZero > trackingOther)
                trackingZero = trackingOther

            // 가운데에 들어갈 숫자가 있는 경우
            answer = if (trackingCenter)
                (trackingZero + trackingOther) * 2 + 1
            else
                (trackingZero + trackingOther) * 2 - 1

            return answer
        }
    }


}

