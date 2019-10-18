package sangmyung_01._1_DynamicProgramming._5_11052_붕어빵판매하기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/11052
 * <p>
 * 2018/01/14 18:35 시작
 */
public class BottomUp {
    final static int MAX = 1001;
    final static int[] D = new int[MAX];
    final static int[] P = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            P[i] = scan.nextInt();
        }
        D[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int temp = P[j] + D[i - j];
                D[i] = (temp > D[i]) ? temp : D[i];
            }
        }


        System.out.print(D[n]);
    }
}
