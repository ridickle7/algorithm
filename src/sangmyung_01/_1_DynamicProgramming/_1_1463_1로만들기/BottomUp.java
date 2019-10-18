package sangmyung_01._1_DynamicProgramming._1_1463_1로만들기;

import java.util.Scanner;

/**
 * Created by ridickle on 2018. 1. 9..
 * https://www.acmicpc.net/problem/1463
 *
 */
public class BottomUp {
    static final int MAX = 1000001;
    static int[] D = new int[MAX];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i = 2 ; i <= n ; i++){
            D[i] = D[i-1] + 1;

            if(i % 2 == 0 && (D[i] > D[i/2] + 1)){
                D[i] = D[i/2] + 1;
            }

            if(i % 3 == 0 && (D[i] > D[i/3] + 1)){
                D[i] = D[i/3] + 1;
            }
        }

        System.out.print(D[n]);
    }
}
