package exercise._2018_05_10_everydayProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class everyday08 {
    static int[] arr;

    public static void main(String[] args) {
        // 정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.
        // Input: [10, 5, 4, 3, -1]
        // Output: 5
        //
        // Input: [3, 3, 3]
        // Output: Does not exist.

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }

        quicksort(0, arr.length - 1);

//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i] + " ");
//        }

        System.out.println(arr[0] == arr[1] ? "Does not exist." : arr[1]);
    }

    private static void quicksort(int left, int right) {
        if(left < right) {
            int pivot = partition(left, right);
            quicksort(left, pivot - 1);
            quicksort(pivot + 1, right);
        }
    }

    private static int partition(int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            if (arr[left] < pivot && (left < right)) {
                left++;
            }

            if (pivot < arr[right] && (left < right)) {
                right++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return left;
    }

    private static void solution(String input) {

    }
}