package acmicpc.bfs.java;

// 문제
// 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만,아직 익지 않은 토마토들도 있을 수 있다.
// 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
// 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다.
//
// 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다.
// 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
//
// 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
//
// 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

// 명세
// 01:44 시작
// 01:53 테스트 케이스 코드 작성
// 03:03 완성
// 03:35 시간초과 이슈 해결

// 느낀 점
// 빡쳐서 "이 병신아 나가 죽어라" 라고 적었지만 자꾸 인덱스 깜빡깜빡하는 버릇을 줄여야할텐데 (이번엔 +1을 안했다...)
// 익은 토마토를 한 번더 순회하는 작업을 수행하기 때문에 문제가 발생한다는 것을 알 수 있었다.
// remain 이슈가 왜 자연스럽게 해결되는지 궁금했으나
// queue값이 비어있으면 자동으로 비어있는 값을 써치하는 과정을 수행하기 떄문에 자연스럽게 remain 검증을 진행하는 것이었다.
// 시간 이슈 말고는 스스로 문제를 풀었기 때문에 어느정도는 만족했다.

// 개인 TIP
// Call by Reference에 대한 업데이트 요소가 생겼다.
// https://library1008.tistory.com/47 (얕은 복사와 깊은 복사)

import acmicpc.Solve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576 {
    static int W;
    static int H;
    static int[][] matrix;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    static int answer = -1;
    static Queue<Point> nextQueue = new LinkedList<>();

    public static void main(String[] args) {
        solve.testSolve();
    }

    public static Solve solve = new Solve() {
        @Override
        public void solution() {
            // bfs 진행
            bfs();

            System.out.println(answer);
        }

        private void bfs() {
            boolean queueIsEmpty = true;
            boolean remained = false;

            Queue<Point> queue = new LinkedList<>(nextQueue);

            if (queue.isEmpty())
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++) {
                        if (matrix[i + 1][j + 1] == -1)
                            // 이 병신아 나가 죽어라
                            visited[i + 1][j + 1] = true;
                        else if (matrix[i + 1][j + 1] == 0)
                            remained = true;
                        else if (!visited[i + 1][j + 1] && matrix[i + 1][j + 1] == 1) {
                            queue.add(new Point(j + 1, i + 1));
                            queueIsEmpty = false;
                        }
                    }
            else {
                queueIsEmpty = false;
                nextQueue.clear();
            }

            if (!queueIsEmpty) {
                answer++;
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    visited[point.y][point.x] = true;

                    for (int i = 0; i < 4; i++) {
                        int nextX = point.x + dx[i];
                        int nextY = point.y + dy[i];

                        // 만약 아직 방문하지 않은 상태라면
                        if (nextX > 0 && nextX < W + 1 && nextY > 0 && nextY < H + 1 && !visited[nextY][nextX]) {
                            if (matrix[nextY][nextX] == 0) {
                                matrix[nextY][nextX] = 1;
                                nextQueue.add(new Point(nextX, nextY));
                            }
                        }
                    }
                }

                bfs();
            } else if (remained)
                answer = -1;
        }

        @Override
        public void input() {
            Scanner scan = new Scanner(System.in);
            W = scan.nextInt();
            H = scan.nextInt();
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];

            for (int i = 1; i < H + 1; i++)
                for (int j = 1; j < W + 1; j++) {
                    matrix[i][j] = scan.nextInt();
                }
        }

        @Override
        public void testSolve() {
            W = 6;
            H = 4;
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];

            matrix[1] = new int[]{0, 0, 0, 0, 0, 0, 0};
            matrix[2] = new int[]{0, 0, 0, 0, 0, 0, 0};
            matrix[3] = new int[]{0, 0, 0, 0, 0, 0, 0};
            matrix[4] = new int[]{0, 0, 0, 0, 0, 0, 1};

            solution();
            clearData();


            W = 6;
            H = 4;
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            matrix[1] = new int[]{0, 0, -1, 0, 0, 0, 0};
            matrix[2] = new int[]{0, -1, 0, 0, 0, 0, 0};
            matrix[3] = new int[]{0, 0, 0, 0, 0, 0, 0};
            matrix[4] = new int[]{0, 0, 0, 0, 0, 0, 1};

            solution();
            clearData();

            W = 6;
            H = 4;
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            matrix[1] = new int[]{0, 1, -1, 0, 0, 0, 0};
            matrix[2] = new int[]{0, 0, -1, 0, 0, 0, 0};
            matrix[3] = new int[]{0, 0, 0, 0, 0, -1, 0};
            matrix[4] = new int[]{0, 0, 0, 0, 0, -1, 1};

            solution();
            clearData();

            W = 5;
            H = 5;
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            matrix[1] = new int[]{0, -1, 1, 0, 0, 0};
            matrix[2] = new int[]{0, 0, -1, -1, -1, 0};
            matrix[3] = new int[]{0, 0, -1, -1, -1, 0};
            matrix[4] = new int[]{0, 0, -1, -1, -1, 0};
            matrix[5] = new int[]{0, 0, 0, 0, 0, 0};

            solution();
            clearData();

            // 2 2
            // 1 -1
            // -1 1
            W = 2;
            H = 2;
            matrix = new int[H + 1][W + 1];
            visited = new boolean[H + 1][W + 1];
            matrix[1] = new int[]{0, 1, -1};
            matrix[2] = new int[]{0, -1, 1};

            solution();
        }

        private void clearData() {
            answer = -1;
        }

        @Override
        public void solve() {
            input();
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
