package kakao_open;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
// cache hit일 경우 실행시간은 1이다.
// cache miss일 경우 실행시간은 5이다.


// 1:20
public class _3_cache {
    static String[] cache;
    static Queue<String> queue;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cacheSize = scan.nextInt();
        cache = new String[cacheSize];
        queue = new LinkedList<>();

        scan.nextLine();
        String str = scan.nextLine();
        // Jeju, Pangyo, Seoul, NewYork, LA, Jeju, Pangyo, Seoul, NewYork, LA
        StringTokenizer st = new StringTokenizer(str, ", ");

        System.out.println(st.countTokens());

        while (st.hasMoreTokens()) {
            queue.add(st.nextToken());
        }

        if (cacheSize == 0)
            System.out.println(queue.size() * 5);

    }
}
