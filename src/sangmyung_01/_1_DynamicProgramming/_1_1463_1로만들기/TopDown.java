package sangmyung_01._1_DynamicProgramming._1_1463_1로만들기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/1463
 *
 */
public class TopDown {
    final static int MAX = 1000001;
    static int[] memorization = new int[MAX];

    public static int Recursion(int inputNum) {
        int temp = 0;

        if (inputNum == 1)  // D[1]
            return 0;

        if (memorization[inputNum] != 0) {  // D[inputNum]이 이미 있는 값인 경우
            return memorization[inputNum];  // 그대로 그 값 차용
        }

        memorization[inputNum] = Recursion(inputNum - 1) + 1;   // D[n-1]

        if (inputNum % 3 == 0) {                                // D[n/3]
            temp = Recursion(inputNum / 3) + 1;

            if (memorization[inputNum] > temp)
                memorization[inputNum] = temp;

        }

        if (inputNum % 2 == 0) {                                // D[n/2]
            temp = Recursion(inputNum / 2) + 1;

            if (memorization[inputNum] > temp)
                memorization[inputNum] = temp;
        }

        return memorization[inputNum];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = scan.nextInt();

        System.out.print(Recursion(inputNum));
    }
}
