package nadongbin._01;

public class _03_insert {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        print(arr);
        insert(arr);
        print(arr);
    }

    private static void insert(int[] arr) {
        // 1. 처음부터 끝까지 실행
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i;

            // 2. i에서부터 0까지의 모든 값을 확인하여 사잇값에 삽입
            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }
        }
    }

    public static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
