package exercise._2018_05_25;

import java.util.*;

public class _2583 {
    // 눈금의 간격이 1인 M(높이)×N(너비) (M,N≤100)크기의 모눈종이가 있다.

    // 이 모눈종이 위에 눈금에 맞추어 K개의 직사각형을 그릴 때, 이들 K개의 직사각형의 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어진다.
    //예를 들어 M=5, N=7 인 모눈종이 위에 <그림 1>과 같이 직사각형 3개를 그렸다면, 그 나머지 영역은 <그림 2>와 같이 3개의 분리된 영역으로 나누어지게 된다.

    static int[][] monun;
    static Integer[] result = new Integer[5001];

    static int m;
    static int n;
    static int k;

    public static void main(String[] args) {
        Arrays.fill(result, 0);
        Scanner scan = new Scanner(System.in);

        m = scan.nextInt();
        n = scan.nextInt();
        k = scan.nextInt();

        monun = new int[m][n];
        for (int i = 0; i < k; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for (int y = x1; y < x2; y++) {
                for (int x = y1; x < y2; x++) {
                    monun[x][y] = -1;
                }
            }
        }
        // print();

        int color = 1;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (monun[x][y] == 0) {
                    bfs(x, y, color);
                    color++;
                }
            }
        }

        Arrays.sort(result);
        List<Integer> list = new ArrayList<>();
        for (int i = result.length - 1; i > -1; i--) {
            int temp = result[i];

            if (temp == 0)
                break;
            else
                list.add(result[i]);
        }

        Collections.reverse(list);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            if (temp != 0)
                System.out.print(temp + " ");
        }
    }

    public static void bfs(int x, int y, int color) {
        int sum = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        monun[x][y] = color;
        result[color]++;
        for (int i = 0; i < dx.length; i++) {
            if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < m && y + dy[i] < n) {
                if (monun[x + dx[i]][y + dy[i]] == 0)
                    bfs(x + dx[i], y + dy[i], color);
            }
        }
    }

    public static void print() {
        for (int x = m - 1; x >= 0; x--) {
            for (int y = 0; y < n; y++) {
                System.out.print(monun[x][y]);
            }
            System.out.println();
        }
    }
}
