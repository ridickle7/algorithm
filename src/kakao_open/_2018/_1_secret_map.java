package kakao_open._2018;

import java.util.Scanner;

public class _1_secret_map {
    // 1. 지도는 한 변의 길이가 n인 정사각형 배열
    //      각 칸은 공백 (" ") or 벽("#")으로 분류
    // 2. 두 장을 겹쳐야 함 (지도1, 지도2)

    // 1 ≦ n ≦ 16
    //arr1, arr2는 길이 n인 정수 배열로 주어진다.
    //정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n - 1을 만족한다.

    static int[] arr1, arr2, arr3;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr1 = new int[n];
        arr2 = new int[n];
        arr3 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr3[i] = arr1[i] | arr2[i];
        }

        print();
    }

    public static void print() {
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }

        for (int i = 0; i < arr3.length; i++) {
            getoutput(arr3[i]);
        }
    }

    private static void getoutput(int input) {
        int temp = input;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(temp % 2 == 1 ? "#" : " ");
            temp /= 2;
        }
        System.out.println("\"" + sb.reverse() + "\"");
    }
}
