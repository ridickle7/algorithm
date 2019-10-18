package kakao_open._2018;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _2_dart {
    // 총 3번의 기회
    // int score = 0~10
    // s ^1 d ^2 t ^3
    // (* 이전거 2배) (# 이전거 마이너스)
    // * : 첫번

//    점수는 0에서 10 사이의 정수이다.
//    보너스는 S, D, T 중 하나이다.
//    옵선은 *이나 # 중 하나이며, 없을 수도 있다.

    // 9시 11분 시작
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int result[] = new int[]{0, 0, 0};
        ArrayList<Pattern> patternList = new ArrayList<>();
        String dartResult = scan.nextLine();

        Pattern number = Pattern.compile("[10]{2}|[1-9]{1}");       // 숫자
        Pattern bonus = Pattern.compile("[S]{1}|[D]{1}|[T]{1}");    // 특정 문자
        Pattern option = Pattern.compile("[*]{1}|[#]{1}");          // 특정 문자

        patternList.add(number);
        patternList.add(bonus);
        patternList.add(option);

        Matcher matcher = patternList.get(0).matcher(dartResult);
        while(matcher.find()){
            System.out.print(matcher.group());
        }
    }
}
