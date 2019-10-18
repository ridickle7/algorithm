package programmers.bfs_dfs

class Network {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))
        }

        // visit를 통해 이미 추가된 것인지 확인한다.
        var visits: ArrayList<ArrayList<Boolean>> = arrayListOf()

        fun solution(n: Int, computers: Array<IntArray>): Int {
            var answer = 0

            // 초기 설정 (모든 값 false)
            visits.apply {
                for (i in 0 until n) {
                    add(arrayListOf())
                    for (j in 0 until n) {
                        get(i).add(false)
                    }
                }

            }

            // 모든 컴퓨터에 대해서 문어발 연결 시작
            for(i in 0 until n){
                // 이미 네트워크가 만들어진 컴퓨터인 경우
                if(!visits[i][i]){
                    // i번 컴퓨터에 대해서 전체적인 문어발 연결 진행
                    search(i, n, computers)
                    // 연결을 진행한 후 해당 네트워크 구축 종료
                    answer++
                }
            }

            return answer
        }

        // 해당 컴퓨터에 대한 연결 정도 확인
        fun search(position: Int, n: Int, computers: Array<IntArray>) {
            for (i in 0 until n)
                // 해당 position의 컴퓨터가 i번 컴퓨터와 연결되어 있고, 네트워크 연결이 된 적이 없는 컴퓨터인 경우
                if (computers[position][i] == 1 && !visits[position][i]){
                    visits[position][i] = true
                    visits[i][position] = true
                    // 문어발식 연결 진행
                    search(i, n, computers)
                }
        }
    }
}