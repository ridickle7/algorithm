package exercise._2018_05_10_everydayProgramming;

// 시작 : 11시 38분
// 끝 : 11시 52분

import java.util.HashMap;
import java.util.Scanner;

public class everyday05 {
    // 정수 배열과 타겟 숫자가 주어지면, 합이 타겟값이 되는 두 원소의 인덱스를 찾으시오.
    // 단, 시간복잡도 O(n) 여야 합니다.

    // sol)
    // value, index 를 쌍으로 갖는 해시맵을 준비한다.
    // target에서 인덱스의 value를 뺀 값을 key로 찾는다.
    // 해당 값이 없을 경우 map에 저장한다.
    // 해당 값이 있을 경우 key에 저장된 value값과 현재 i값을 리턴한다.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = {2, 5, 6, 1, 10};
        int target = scan.nextInt();

        System.out.println(solution(input, target)[0] + " " + solution(input, target)[1]);
    }

    public static int[] solution(int[] input, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int next = target - input[i];
            if (map.containsKey(next)) {
                return new int[]{map.get(next), i};
            }
            map.put(input[i], i);
        }

        return new int[]{-1, -1};
    }
}
