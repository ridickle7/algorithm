package acmicpc;

// 문제

// 명세

// 느낀 점

// 개인 TIP

public interface Solve {
    // 실제 로직
    abstract void solution();

    // 데이터 넣는 작업 수행
    abstract void input();

    // 테스트 케이스 설정 및 solution() 호출
    abstract void testSolve();

    // 백준 scanner 대응
    abstract void solve();
}
