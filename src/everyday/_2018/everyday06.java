package everyday._2018;

import java.util.ArrayList;
import java.util.Scanner;

public class everyday06 {
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        // 간격(interval)로 이루어진 배열이 주어지면, 겹치는 간격 원소들을 합친 새로운 배열을 만드시오.
        // 간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.
        // Input: {{2,4}, {1,5}, {7,9}}
        // Output: {{1,5}, {7,9}}
        //
        // Input: {{3,6}, {1,3}, {2,4}}
        // Output: {{1,6}}

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            list.add(new int[]{a, b});
        }

        quickSort(0, N - 1);
        list = solution();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " + " + list.get(i)[1]);
        }
    }

    public static void quickSort(int left, int right) {
        if (left < right) {
            int pivot = partition(left, right);
            quickSort(left, pivot - 1);
            quickSort(pivot + 1, right);
        }
    }

    private static int partition(int left, int right) {
        int pivot = list.get((left + right) / 2)[0];

        while (left < right) {
            while ((list.get(left)[0] < pivot) && (left < right)) {   // 왼쪽 값이 피벗보다 값이 작은 경우
                left++;
            }

            while ((pivot < list.get(right)[0]) && (left < right)) {   // 오른쪽 값이 피벗보다 값이 큰 경우
                right--;
            }

            if (left < right) {
                int[] temp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, temp);
            }
        }
//
//        int[] temp = list.get(pivot);
//        list.set(pivot, list.get(right));
//        list.set(right, temp);

        return left;
    }

    private static ArrayList<int[]> solution() {
        ArrayList<int[]> answer = new ArrayList<>();
        answer.add(list.get(0));

        for (int i = 0; i < list.size() - 1; i++) {
            int[] current = answer.get(answer.size() - 1);
            int[] next = list.get(i + 1);

            if (current[1] > next[0]) { // inside에 속한 경우
                answer.remove(answer.size() - 1);
                answer.add(new int[]{current[0], Math.max(current[1], next[1])});
            } else {
                answer.add(next);
            }
        }

        return answer;
    }
}
