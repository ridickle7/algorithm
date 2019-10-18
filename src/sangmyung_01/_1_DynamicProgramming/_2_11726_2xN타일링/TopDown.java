package sangmyung_01._1_DynamicProgramming._2_11726_2xN타일링;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/11726
 *
 * 2018/01/09 08:49 시작
 * 2018/01/09 08:58 타임아웃
 * 2018/01/09 09:22 하향식으로 풀면 타임 아웃 (동알힌 값을 계속 계산하려 하므로)
 */
public class TopDown {
    static final int MAX = 1001;
    static final int[] D = new int[MAX];

    private static int Recursion(int n) {
        if (n == 1)
            return 1;

        else if (n == 2)
            return 2;

        else
            return (Recursion(n - 1) + Recursion(n - 2)) % 10007;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.print(Recursion(n));
    }
}
