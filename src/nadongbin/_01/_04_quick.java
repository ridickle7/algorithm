package nadongbin._01;

public class _04_quick {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        print(arr);
        quick(arr, 0, arr.length - 1);
        print(arr);
    }

    private static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // pivot을 하나 정한다.
        int pivot = left;
        int leftIndex = left + 1;
        int rightIndex = right;

        // 그 pivot 을 기준으로 다음 값에서부터 right까지 범위의 while문을 돌린다
        while (leftIndex <= rightIndex) {

            // 왼쪽에서부터 pivot보다 크거나 같은 값을 찾는다.
            while (leftIndex <= right && arr[leftIndex] <= arr[pivot])
                leftIndex++;

            // 오른쪽에서부터 pivot보다 작은 값을 찾는다.
            while (rightIndex > left && arr[rightIndex] >= arr[pivot]) {
                rightIndex--;
            }

            // 만약 rightIndex가 leftIndex보다 왼쪽에 있는 경우 rightIndex와 pivot을 바꿔준다
            if (leftIndex > rightIndex) {
                int temp = arr[pivot];
                arr[pivot] = arr[rightIndex];
                arr[rightIndex] = temp;
            }

            // 아닐 경우 leftIndex와 rightIndex의 값을 바꿔준다.
            else {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }

        quick(arr, left, rightIndex - 1);
        quick(arr, rightIndex + 1, right);
    }

    public static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
