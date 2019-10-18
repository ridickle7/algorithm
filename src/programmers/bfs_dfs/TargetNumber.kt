package programmers.bfs_dfs

class TargetNumber {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solution(intArrayOf(1, 1, 1, 1, 1), 3)
        }

        var answer = 0
        fun solution(numbers: IntArray, target: Int): Int {

            calculate(numbers[0], numbers, target, 0)
            calculate(-numbers[0], numbers, target, 0)

            return answer
        }

        fun calculate(number: Int, numbers: IntArray, target: Int, position: Int) {
            if (position < numbers.size - 1) {
                calculate(number + numbers[position + 1], numbers, target, position + 1)
                calculate(number - numbers[position + 1], numbers, target, position + 1)
            } else if (position == numbers.size - 1) {
                if (number == target)
                    answer += 1
            }
        }
    }
}