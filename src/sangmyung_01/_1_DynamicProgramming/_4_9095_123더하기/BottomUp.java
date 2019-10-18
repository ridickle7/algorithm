package sangmyung_01._1_DynamicProgramming._4_9095_123더하기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/9095
 * <p>
 * 2018/01/09 10:14 시작 (24 중단 / 45 다시 시작)
 */
public class BottomUp {
    final static int MAX = 12;
    final static int[] D = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        for (int i = 4; i <= 11; i++) {
            D[i] = D[i - 1] + D[i - 2] + D[i - 3];
        }

        while (n > 0) {
            int num = scan.nextInt();
            System.out.println(D[num]);

            n--;
        }
    }
}
