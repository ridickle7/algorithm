package exercise.acmicpc.bfs.java;

// 문제
// <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
// 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
// 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
//
// 대각선상에 집이 있는 경우는 연결된 것이 아니다.
// <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
// 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

// 명세
// 21:22 시작
// 22:38 끝

// 느낀 점
// 나가 죽어야할 듯.. 자꾸 y x 거꾸로 적네...
// 2중 포문을 돌리는 건 필수구나... 그런데 왜 자꾸 visited 를 뺴먹니
// nextX를 x로 적고 앉아있고...

// 개인 TIP
// 조만간 x, y를 바꿔서 만들어봐야겠다.. 지금 만들어볼까?

import exercise.acmicpc.Solve;

import java.util.*;

public class _2667 {
    private static int M = -1;
    private static ArrayList<String> strings = new ArrayList<>();
    public static int answer = 0;
    private static int[] answers;
    private static int[] dx = new int[]{0, 0, -1, 1};
    private static int[] dy = new int[]{-1, 1, 0, 0};
    private static boolean[][] matrix;
    private static boolean[][] visited;

    public static void main(String[] args) {
        solve.solve();
    }

    public static Solve solve = new Solve() {
        @Override
        public void solution() {
            matrix = new boolean[M + 1][M + 1];
            visited = new boolean[M + 1][M + 1];
            answers = new int[M * M];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++)
                    matrix[i + 1][j + 1] = strings.get(i).charAt(j) != '0';
            }

            bfs();
            Arrays.sort(answers);

            System.out.println(answer);
            for (int i = 0; i < answers.length; i++)
                if (answers[i] != 0)
                    System.out.println(answers[i]);
        }

        private void bfs() {
            int count = 0;

            // 반복문 무조건 돌려야함
            for (int x = 1; x < M + 1; x++) {
                for (int y = 1; y < M + 1; y++) {
                    // 만약 방문하지 않았는데 해당 값이 존재한다면 영역 업데이트 진행
                    if (!visited[y][x] && matrix[y][x]) {
                        answer++;
                        count++;

                        // Queue를 설정하여 이 구역에 미친 X는 나야를 진행한다.
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(x, y));
                        visited[y][x] = true;

                        // 돌려라 돌려
                        while (!queue.isEmpty()) {
                            answers[count]++;
                            Point point = queue.poll();

                            // 상하좌우 확인
                            for (int i = 0; i < 4; i++) {
                                int nextX = point.x + dx[i];
                                int nextY = point.y + dy[i];

                                if (nextX > 0 && nextX < M + 1 && nextY > 0 && nextY < M + 1 && matrix[nextY][nextX] && !visited[nextY][nextX]) {
                                    queue.add(new Point(nextX, nextY));
                                    visited[nextY][nextX] = true;
                                }
                            }
                        }
                    } else
                        visited[y][x] = true;
                }
            }
        }

        @Override
        public void solve() {
            input();
            solution();
        }

        @Override
        public void testSolve() {
            M = 7;

            strings.add("0110100");
            strings.add("0110101");
            strings.add("1110101");
            strings.add("0000111");
            strings.add("0100000");
            strings.add("0111110");
            strings.add("0111000");

            solution();
        }

        @Override
        public void input() {
            Scanner scan = new Scanner(System.in);
            M = scan.nextInt();
            scan.nextLine();

            for (int i = 0; i < M; i++) {
                String str = scan.nextLine();
                strings.add(str);
            }
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
