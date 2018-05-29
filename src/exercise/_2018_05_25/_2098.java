package exercise._2018_05_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2098
// sol : http://stack07142.tistory.com/154
public class _2098 {
    static int N;
    static int[][] W;

    static final int INF = 100000000;
    static final int SOURCE = 0;
    static final int NOT_CONNECTED = 0;
    static final int NOT_VISITED = -1;

    // dp[N][B] : 현재 N 마을에서 B에 속한 마을들을 방문했을 때, 나머지 마을들을 방문 후 시작점으로 돌아갈때 최소 cost
    static int[][] dp = new int[16][1 << 16];

    static {
        for (int i = 0; i < 16; i++) {
            Arrays.fill(dp[i], NOT_VISITED);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // solve, 시작점 & 도착점 : 0
        System.out.println(solution(SOURCE, 1 << SOURCE));
    }

    private static int solution(int cur, int B) {
        // 방문한 적이 있는 경우 이전 memoization 값 활용
        if (dp[cur][B] != NOT_VISITED)
            return dp[cur][B];

        // 모든 마을을 방문한 경우 값 리턴
        if (B == (1 << N) - 1) {
            return dp[cur][B] = W[cur][SOURCE] != NOT_CONNECTED ? W[cur][SOURCE] : INF;
        }

        dp[cur][B] = INF;
        for (int i = 0; i < N; i++) {
            // 만약 이어지는 길이 없고, 방문했던 적이 있다면
            if (W[cur][i] == NOT_CONNECTED || (B & (1 << i)) > 0)
                continue;

            //
            dp[cur][B] = Math.min(dp[cur][B], solution(i, B | (1 << i)) + W[cur][i]);
        }

        return dp[cur][B];
    }
}
