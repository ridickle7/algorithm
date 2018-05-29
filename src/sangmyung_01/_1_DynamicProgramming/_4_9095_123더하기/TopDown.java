package sangmyung_01._1_DynamicProgramming._4_9095_123더하기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/9095
 * <p>
 * 2018/01/09 10:04 시작
 */
public class TopDown {
    final static int MAX = 12;
    final static int[] D = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n > 0) {
            System.out.print(solution(scan.nextInt()));
            n--;
        }
    }

    public static int solution(int problem) {
        int answer = 0;

        D[0] = 0;
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;

        answer = Recursion(problem);
        return answer;
    }

    public static int Recursion(int number) {
        // 이미 있는 값이면 이전의 값을 리턴한다.
        if (D[number] > 0) {
            return D[number];
        }

        D[number] = Recursion(number - 1) + Recursion(number - 2) + Recursion(number - 3);

        return D[number];
    }

}
