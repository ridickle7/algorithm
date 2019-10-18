package nadongbin._01;

public class _01_select {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        print(arr);
        select(arr);
        print(arr);
    }

    private static void select(int[] arr) {
        int minIndex;

        for (int i = 0; i < arr.length; i++) {
            // 1. 가장 작은 index를 가리킴
            minIndex = i;

            for (int j = i; j < arr.length; j++) {
                // 2. 더 작은 value를 찾을 경우 해당 index 갱신
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            // 3. swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
