package exercise._2018_05_10_everydayProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class everyday09 {
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scan.nextInt());
        }

        list = solution(list);
        for(int i=0 ; i<list.size() ; i++){
            System.out.printf(list.get(i) + " ");
        }
    }

    private static ArrayList<Integer> solution(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i) == 0){
                list.remove(i);
                list.add(0);
            }
        }

        return list;
    }
}
