package exercise.acmicpc.bfs.java;

// 문제
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
// 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
//
// 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
// 입력
// 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
// 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
//
// 출력
// 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

// 명세
// 16:30 시작
// 끝

// 느낀 점
// 배열의 경우 call by reference 로 인해 그 이전값을 계속 기억한다. 이 부분을 어떻게 손 볼 수 있는 방법이 있을까?
// (새 배열 할당해주는 건 실패.. 값 갱신이 이상하게 되고, 메모리상 성능 저하 우려)
// 일반 반복문으로 상하좌우를 나타내주는 것보다 dx, dy로 처리해주는 게 깨끗한 것 같다.
// 그리고 BFS는 무조건 Queue다 뀨

// 개인 TIP

import exercise.acmicpc.Solve;

import java.util.*;

public class _2178 {
    private static int N;
    private static int M;
    private static ArrayList<String> strings = new ArrayList<>();
    private static boolean[][] matrix;
    private static int[][] visited;

    // 상하좌우
    private static int[] dx = new int[]{0, 0, -1, 1};
    private static int[] dy = new int[]{-1, 1, 0, 0};

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solve.solve();

    }

    private static Solve solve = new Solve() {
        @Override
        public void solution() {
            // 1. String을 matrix로 만든다
            matrix = new boolean[N + 1][M + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i + 1][j + 1] = strings.get(i).charAt(j) == '1';
                }
            }

            int x = 1;
            int y = 1;
            visited = new int[N + 1][M + 1];
            visited[1][1] = 1;

            // 2. 갈 수 있는 곳인지 체크한다
            // 상
            bfs(1, 1);

            // 3.
            System.out.println(answer);
        }

        private void bfs(int x, int y) {
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(x, y));

            while (!queue.isEmpty()) {
                Point point = queue.poll();

                // x y 좌표 확인
                if (point.x == M && point.y == N)
                    answer = visited[point.y][point.x];

                // 상하좌우로 움직일 수 있는지 확인
                else {
                    for (int i = 0; i < dx.length; i++) {
                        int nextX = point.x + dx[i];
                        int nextY = point.y + dy[i];

                        // 지정된 범위 내에 있는 경우
                        if (nextX > 0 && nextX < M + 1 && nextY > 0 && nextY < N + 1) {
                            // 해당 지점으로 갈 수 있고, 방문한 적이 없는 경우
                            if (matrix[nextY][nextX] && visited[nextY][nextX] < 1) {
                                // 해당 값을 갱신해주고
                                visited[nextY][nextX] = visited[point.y][point.x] + 1;
                                // queue에 값을 추가 시킨다.
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                    }
                }
            }
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

            for (int i = 0; i < N; i++) {
                strings.add(scan.next());
            }
        }

        private void resultClear() {
            matrix = null;
            answer = Integer.MAX_VALUE;
        }

        @Override
        public void testSolve() {
            N = 4;
            M = 6;
            strings = new ArrayList<>(Arrays.asList("101111", "101010", "101011", "111011"));

            solution();
            resultClear();

            N = 4;
            M = 6;
            strings = new ArrayList<>(Arrays.asList("110110", "110110", "111111", "111101"));

            solution();
            resultClear();

            N = 2;
            M = 25;
            strings = new ArrayList<>(Arrays.asList("1011101110111011101110111", "1110111011101110111011101"));

            solution();
            resultClear();

            N = 7;
            M = 7;
            strings = new ArrayList<>(Arrays.asList("1011111", "1110001", "1000001", "1000001", "1000001", "1000001", "1111111"));

            solution();
        }
    };

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
