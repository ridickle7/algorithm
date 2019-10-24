package exercise.acmicpc.bfs.java;

// 문제
// 수빈이는 동생과 숨바꼭질을 하고 있다.
// 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
// 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
//
// 수빈이는 걷거나 순간이동을 할 수 있다.
// 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

// 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

// 명세
// 02:44 시작
// 04:04 끝

// 느낀 점
// 정말 어려운 문제인 줄 알았는데 BFS로 푸는 로직을 확인해보니 쉬운 문제였다
// 반례에 이슈가 많았다.
// 1. 4 7 -> 3 : 값을 확인했음에도 while문을 돌리고 있기에 즉각 리턴으로 해결
// 1. 4 1 -> 1 : 같은 값인지 확인해보는 선작업 수행


// 개인 TIP


import exercise.acmicpc.Solve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
    static int N;
    static int K;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) {
        solve.solve();
    }

    public static Solve solve = new Solve() {
        @Override
        public void solution() {
            // * 2
            visited = new boolean[100001];

            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(N, answer));
            visited[N] = true;

            if (N == K)
                System.out.println(0);

            else
                while (!queue.isEmpty()) {
                    Point newN = queue.poll();
                    Point[] cases = new Point[]{
                            new Point(newN.index - 1, newN.count + 1),
                            new Point(newN.index + 1, newN.count + 1),
                            new Point(newN.index * 2, newN.count + 1)};

                    for (Point index : cases) {
                        // 만약 case에 다 속한다면
                        if (index.index > -1 && index.index < 100001) {
                            if (index.index == K) {
                                answer = index.count;
                                System.out.print(answer);
                                return;
                            } else if (!visited[index.index]) {
                                visited[index.index] = true;
                                queue.add(index);
                            }
                        }
                    }
                }
        }

        @Override
        public void input() {
            Scanner scan = new Scanner(System.in);
            N = scan.nextInt();
            K = scan.nextInt();
        }

        @Override
        public void testSolve() {
            N = 5;
            K = 17;

            solution();
        }

        @Override
        public void solve() {
            input();
            solution();
        }
    };

    static class Point {
        int index;
        int count;

        public Point(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
