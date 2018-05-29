package exercise._2018_05_10_everydayProgramming;

import java.util.Scanner;

// 시작 : 6시 23분
// 끝 : 6시 33분


public class everyday02 {
    // 피보나치 배열은 0과 1로 시작하며, 다음 피보나치 수는 바로 앞의 두 피보나치 수의 합이 된다.
    // 정수 N이 주어지면, N보다 작은 모든 짝수 피보나치 수의 합을 구하여라.

    // ex>  Input: N = 12
    //      Output: 10 // 0, 1, 2, 3, 5, 8 중 짝수인 2 + 8 = 10.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int prev = 1;
        int current = 2;
        int answer = 2;

        while (current < N) {
            int temp = current;

            current += prev;
            if (current % 2 == 0)
                answer += current;

            prev = temp;
        }

        System.out.println(answer);
    }
}
