package everyday._2018;

import java.util.Scanner;

public class everyday01 {
    // 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n).
    // -이면 answer 값 업데이트만 진행
    // +이면 비교 후 합 구하기

    public static void main(String[] args) {
        // write your code here
        int[] arr = {-1, 3, -1, 5};
        Scanner scan = new Scanner(System.in);

        System.out.println(solution2(arr));
    }

    private static int solution2(int[] arr) {
        int max = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(currentMax + arr[i], arr[i]); // 이어진 연결을 자를지 / 이어갈지 결정
            max = Math.max(currentMax, max);                    // 위에서 결정한 값과 기존 얻은 최대값 비교
        }

        return max;
    }
}
