package exercise._2018_05_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ridickle on 2018. 02. 05..
 * 4:30 시작
 * 4:35 종료
 *
 * 교훈
 * 1. 어려운 줄 알았는데 의외로 어렵지 않았다.
 * 2.
 */

// https://www.acmicpc.net/problem/9655
public class _9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = Integer.parseInt(br.readLine()) % 2 == 0 ? "CY" : "SK";
        System.out.print(str);
    }
}
