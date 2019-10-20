package exercise.acmicpc.bfs.java;

// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번 까지이다.
//
// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
// 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 명세
// 14:20 시작
// 15:30 끝

// 느낀 점
// 알고리즘 안한지 너무 오래됬다... 근데 Test case 작성하다가 오류난 것도 있는지라....
// 그래도 다시 다잡아가면서 문제점을 수정할 필요는 있어보인다.
// DFS : 세로 (DEEP 하게)
// BFS : 가로 (Breadth 하게)

// 개인 TIP
// 정점 / 간선 문제는 왠만하면 2차원 배열로 해결해야한다!

import exercise.acmicpc.Solve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1260 {
    public static void main(String[] args) {
         solve.testSolve();
//        solve.solve();
    }

    private static boolean[][] matrix = null;
    private static boolean[] visited = null;

    private static int N;
    private static int M;
    private static int V;

    private static StringBuilder sbBFS = new StringBuilder();
    private static StringBuilder sbDFS = new StringBuilder();

    private static Solve solve = new Solve() {
        @Override
        public void solution() {
            // DFS : 길이 우선 탐색 (세로)
            dfs(V);
            System.out.println(sbDFS.toString());

            visited = new boolean[N + 1];

            // BFS : 너비 우선 탐색 (가로)
            bfs(V);
            System.out.println(sbBFS.toString());
        }

        // BFS에 맞게 순회하며 관련 데이터를 선입선출 자료구조에 넣는다. -> queue
        private void bfs(int target) {
            // 다음 next step의 순차적 접근을 위해 queue 를 둔다.
            Queue<Integer> queue = new LinkedList<>();
            queue.add(target);
            visited[target] = true;

            while (!queue.isEmpty()) {
                int front = queue.poll();
                sbBFS.append(front).append(" ");

                for (int i = 1; i < visited.length; i++) {
                    if (!visited[i] && matrix[front][i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }

        // 해당 타겟으로 계속 파고 들어가야한다. -> 재귀
        private void dfs(int target) {
            visited[target] = true;
            sbDFS.append(target).append(" ");
            int newTarget = -1;

            for (int i = 1; i < visited.length; i++) {
                if (!visited[i] && matrix[target][i]) {
                    newTarget = i;
                    dfs(newTarget);
                }
            }
        }

        private void resultClear() {
            sbBFS = new StringBuilder();
            sbDFS = new StringBuilder();
        }

        @Override
        public void solve() {
            input();
            solution();
        }

        @Override
        public void input() {
            Scanner scan = new Scanner(System.in);

            N = scan.nextInt();
            M = scan.nextInt();
            V = scan.nextInt();

            matrix = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < M; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                matrix[x][y] = true;
                matrix[y][x] = true;
            }
        }

        @Override
        public void testSolve() {
            // 1. 변수 세팅
            int[] input1_1 = new int[]{4, 5, 1};
            int[] input1_2 = new int[]{1, 2};
            int[] input1_3 = new int[]{1, 3};
            int[] input1_4 = new int[]{1, 4};
            int[] input1_5 = new int[]{2, 4};
            int[] input1_6 = new int[]{3, 4};
            testInput(input1_1, input1_2, input1_3, input1_4, input1_5, input1_6);

            // 2. result 호출
            solution();
            resultClear();
            // 1 2 4 3
            // 1 2 3 4

            // 1. 변수 세팅
            int[] input2_1 = new int[]{5, 5, 3};
            int[] input2_2 = new int[]{5, 4};
            int[] input2_3 = new int[]{5, 2};
            int[] input2_4 = new int[]{1, 2};
            int[] input2_5 = new int[]{3, 4};
            int[] input2_6 = new int[]{3, 1};
            testInput(input2_1, input2_2, input2_3, input2_4, input2_5, input2_6);

            // 2. result 호출
            solution();
            resultClear();
            // 3 1 2 5 4
            // 3 1 4 2 5

            // 1. 변수 세팅
            int[] input3_1 = new int[]{1000, 1, 1000};
            int[] input3_2 = new int[]{999, 1000};
            testInput(input3_1, input3_2);

            // 2. result 호출
            solution();
            resultClear();
            // 1000 999
            // 1000 999
        }

        private <T> void testInput(T... inputs) {
            int[][] params = (int[][]) inputs;
            int[] firstLine = params[0];

            N = firstLine[0];
            M = firstLine[1];
            V = firstLine[2];

            matrix = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i < params.length; i++) {
                int[] param = params[i];
                matrix[param[0]][param[1]] = true;
                matrix[param[1]][param[0]] = true;
            }
        }
    };
}
