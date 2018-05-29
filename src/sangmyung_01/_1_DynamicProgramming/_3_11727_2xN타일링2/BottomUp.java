package sangmyung_01._1_DynamicProgramming._3_11727_2xN타일링2;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/11727
 * <p>
 * 2018/01/09 09:38 시작
 */
public class BottomUp {
    final static int MAX = 1001;
    final static int[] D = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        D[1] = 1;
        D[2] = 3;

        for (int i = 3; i <= n; i++) {
            D[i] = (D[i - 1] + 2 * D[i - 2]) % 10007;
        }

        System.out.print(D[n]);
    }
}
