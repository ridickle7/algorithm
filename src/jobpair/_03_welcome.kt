package jobpair

// OO 회사는 신입 사원 교육을 진행합니다.
// 교육은 팀 단위로 진행하며, 입사 시험에서 받았던 점수가 비슷한 사원을 같은 팀으로 배정합니다.
// 이때, 팀에 배정할 사원 중 점수가 가장 높은 사원과 점수가 가장 낮은 사원의 점수 차가 max_diff 이하여야 합니다.
// 이 기준으로 팀을 만들었을 때, 사원이 가장 많은 팀의 팀원 수를 구하려 합니다.

// solution 함수의 매개변수로 모든 신입 사원의 입사 시험 점수를 담은 배열 grade와 허용할 점수 차이 max_diff가 주어집니다.
// 이때, 사원이 가장 많은 팀의 팀원 수를 구하는 함수, solution을 완성해주세요.

class _03_welcome {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            System.out.println(solution(arrayOf(4, 1, 3, 5).toIntArray(), 2))

        }

        fun solution(grade: IntArray, max_diff: Int): Int {
            var answer = 0

            // grade는 길이 1 이상 1,000,000 이하인 배열입니다. (0 아님)
            grade.sort()
//            var set = grade.toHashSet()
//            var prevValue = grade[0]
//            var currentAnswer = 0
//
//            while (set.size != 0) {
//                set.remove(prevValue)
//
//                // 만약 다음값이 있다면
//                if (set.contains(prevValue + max_diff)) {
//                    currentAnswer += 1
//                    prevValue += max_diff
//                } else {
//                    answer = Math.max(answer, currentAnswer)
//                    currentAnswer = 0
//                    prevValue = if (set.size != 0) set.first() else break
//                }
//            }

            var currentAnswer = 0

            var set = grade.toHashSet()

            while (set.size != 0) {
                val indexValue = set.first()
                val index = grade.indexOf(indexValue)

                //
                for (i in index until grade.size) {
                    if (grade[i] < indexValue + max_diff)
                        currentAnswer += 1
                    else {
                        answer = Math.max(answer, currentAnswer + 1)
                        currentAnswer = 0
                        set.remove(indexValue)

                        break
                    }
                }

                if (currentAnswer != 0) {
                    answer = Math.max(answer, currentAnswer + 1)
                    currentAnswer = 0
                    set.remove(indexValue)
                }
            }

            return answer
        }
    }
}