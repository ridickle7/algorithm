package everyday._2018;

// 시작 : 11시 38분
// 끝 : 11시 52분

import java.util.Scanner;

public class everyday04 {
    // 정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오.
    // 팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다.
    // 단, 정수를 문자열로 바꾸면 안됩니다.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        System.out.println(solution(input));
    }

    public static boolean solution(int input) {
        if (input < 0)
            return false;

        else {
            int length = (int) Math.log10(input) + 1;

            while (length > 1) {
                int front = input / (int) Math.pow(10, length - 1);
                int last = input % 10;

                if (front != last)
                    return false;

                else {
                    input = input - (int) Math.pow(10, length - 1) * front;
                    input /= 10;
                    length = length - 2;
                }
            }
        }
        return true;
    }
}
