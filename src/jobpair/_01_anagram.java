package jobpair;

// 애너그램(Anagram) 이란 주어진 단어를 이루는 문자의 위치를 뒤바꾸어 새로운 단어를 만드는 것을 말합니다. 예를 들어 listen의 문자 위치만 바꾸면 silent가 되며 두 단어를 애너그램이라고 부릅니다.
//
// 두 문자열 a와 b를 입력받아 두 문자열이 애너그램이면 true를 그렇지 않으면 false를 반환하도록 함수 solution을 완성해 주세요.

// 제한사항
// 각 문자열의 길이는 10만 이하입니다.
// 문자열은 알파벳 소문자와 대문자로만 이루어져 있습니다.
// 두 단어가 애너그램인지 판단할 때 대문자와 소문자를 구분하지 않습니다.


import java.util.Arrays;

public class _01_anagram {
    public static void main(String[] args) {

    }

    public boolean solution(String a, String b) {
        boolean answer = true;

        // 두 단어가 애너그램인지 판단할 때 대문자와 소문자를 구분하지 않습니다.
        char[] aArray = a.toUpperCase().toCharArray();
        char[] bArray = b.toUpperCase().toCharArray();

        // 순차 정렬 진행
        Arrays.sort(aArray);
        Arrays.sort(bArray);

        // string으로 바꿈
        String aStr = new String(aArray);
        String bStr = new String(bArray);

        // 문자열 비교
        if (aStr.equals(bStr))
            answer = true;
        else
            answer = false;

        return answer;
    }
}
