package sangmyung_01._1_DynamicProgramming._5_11052_붕어빵판매하기;

import java.util.Scanner;

public class exercise {
    final static int MAX = 1001;
    final static int[] D = new int[MAX];
    final static int[] P = new int[MAX];

    // 1. topdown
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            P[i] = scan.nextInt();
        }

        D[0] = 0;
        P[0] = 0;


    }

//    // 2. bottomUp
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//
//        for (int i = 1; i <= n; i++) {
//            P[i] = scan.nextInt();
//        }
//
//        D[0] = 0;
//        P[0] = 0;
//    }
}
