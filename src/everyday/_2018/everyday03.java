package everyday._2018;

import java.util.ArrayList;
import java.util.Scanner;

// 소요시간 : 1시간반
public class everyday03 {
    // 정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오. (시간 복잡도 제한 없습니다).
    static ArrayList<String> strArr = new ArrayList<>();
    static String input = "(";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        calculate(input, n - 1, n);

        System.out.print(strArr.size() + "__");
        for (int i = 0; i < strArr.size(); i++) {
            System.out.print(strArr.get(i) + " ");
        }
    }


    public static void calculate(String prototype, int leftNum, int rightNum) {
        // leftNum 과 rightNum 이 모두 0이 되어야 추가
        if (leftNum == 0 && rightNum == 0)
            strArr.add(prototype);

        else if (leftNum >= 0 && rightNum >= 0) {
            if (leftNum == 0) {
                prototype += ")";
                calculate(prototype, leftNum, rightNum - 1);
            } else if(leftNum <= rightNum){
                calculate(prototype + "(", leftNum - 1, rightNum);
                calculate(prototype + ")", leftNum, rightNum - 1);
            }
        }
    }
}
