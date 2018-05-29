package exercise._2018_05_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ridickle on 2018. 05. 25..
 * 2:35 시작
 * 3:00 완료
 *
 * 교훈
 * 1. HashMap은 갑이다.
 * 2. 자료구조 공부하자
 */

// https://www.acmicpc.net/problem/1620
public class _1620 {
    // static ArrayList<String> doGam = new ArrayList<>();
    static ReverseHashMap<Integer, String> doGam = new ReverseHashMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //readLine()이용해 String 형태로 개행문자(엔터)까지 포함해 한줄을 통째로 입력받아 int로 형변환
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());     // 도감에 수록 되어 있는 포켓몬의 개수 (1~100000)
        int M = Integer.parseInt(st.nextToken());     // 맞추어야 하는 문제의 개수         (1~100000)

        for (int i = 1; i <= N; i++) {
            //nextToken()을 통해 띄어쓰기(" ")를 제거하고 남은 숫자를 스트링 형태에서 int로 형변환하여 arr에 저장. k++를 이용해 인덱스 증가
//            doGam.add(br.readLine());
            doGam.put(i, br.readLine());
        }

        Pattern p = Pattern.compile("(^[0-9]*$)");
        Matcher m;

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
//            try {
//                System.out.println(doGam.get(Integer.parseInt(str) - 1));
//            } catch (NumberFormatException e) {
//                System.out.println(doGam.indexOf(str) + 1);
//            }
            m = p.matcher(str);
            if (m.find())    // 숫자인 경우
            {
                System.out.println(doGam.get(Integer.parseInt(str)));
            } else            // 문자인 경우
            {
                System.out.println(doGam.getKey(str));
            }
        }
    }

    static class ReverseHashMap<K, V> extends HashMap<K, V> {

        Map<V, K> reverseMap = new HashMap();

        @Override
        public V put(K key, V value) {
            reverseMap.put(value, key);
            return super.put(key, value);
        }

        public K getKey(V value) {
            return reverseMap.get(value);
        }
    }
}
