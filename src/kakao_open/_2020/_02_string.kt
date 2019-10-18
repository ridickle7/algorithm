package kakao_open._2020

class _02_string {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.out.println(solution("xababcdcdababcdcd"))
        }

        fun solution(s: String): Int {
            var answer = s.length

            // v에 대해 1단계부터 재귀적으로 수행하면 빈 문자열이 반환됩니다.
            // u의 앞뒤 문자를 제거하고, 나머지 문자의 괄호 방향을 뒤집으면 ""이 됩니다.
            // 따라서 생성되는 문자열은 "(" + "" + ")" + ""이며, 최종적으로 "()"로 변환됩니다.
            return answer
        }
    }


}

class Solution {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        return answer
    }
}