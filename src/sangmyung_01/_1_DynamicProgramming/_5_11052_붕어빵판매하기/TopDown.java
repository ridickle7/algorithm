package sangmyung_01._1_DynamicProgramming._5_11052_붕어빵판매하기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/11052
 * <p>
 * 2018/01/13 18:35 시작
 */
public class TopDown {
    final static int MAX = 1001;
    final static int[] D = new int[MAX];
    static int[] P = new int[MAX];

    public static int Recursion(int n) {
        if (n == 0)
            return 0;

        return P[n];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            P[i] = scan.nextInt();
        }

        for (int i = n; i > 0; i--) {
            for(int j=1 ; j<i ; j++) {
                D[i] = P[i] + Recursion(n - i);
            }
        }

        System.out.println(D[n]);
    }
}
