package sangmyung_01._1_DynamicProgramming._2_11726_2xN타일링;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/11726
 *
 * 2018/01/09 08:58 시작
 * 2018/01/09 09:04 스택 오버플로우로 인한 고민
 * 2018/01/09 09:17 확인
 */
public class BottomUp {
    static final int MAX = 1001;
    static final int[] D = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= n; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }
        System.out.print(D[n]);
    }
}