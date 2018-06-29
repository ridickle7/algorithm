package exercise._2018_05_10_everydayProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class everyday07 {
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        // 주어진 string 에 모든 단어를 거꾸로 하시오.
        // Input: “abc 123 apple”
        // Output: “cba 321 elppa”

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String output = solution(input);
        System.out.print(output);
    }

    private static String solution(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i > -1; i--)
            sb.append(input.charAt(i));

        return sb.toString();
    }
}