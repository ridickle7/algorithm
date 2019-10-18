package exercise._2018_05_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N이 주어진다. (2<=N<=16)
 * Created by ridickle on 2018. 02. 25..
 * 6:45 시작
 * 종료
 * <p>
 * 교훈
 * 1. 
 * 2.
 */

// https://www.acmicpc.net/problem/2098
public class _10971 {
    static int[][] W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    W[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }


    }
}
