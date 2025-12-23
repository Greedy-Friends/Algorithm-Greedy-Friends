package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 독일 로또: k개 숫자 중에서 6개 선택
 *
 * k개 숫자가 주어질 때, 6개를 고르는 모든 조합을 사전순으로 출력
 *
 * 입력: 여러 테스트 케이스
 *       k가 0이면 종료
 */
// 로또(실버2) - 백트래킹
public class BOJ_6603 {
    static int k;
    static int[] numbers;
    static int[] selected = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (k == 0) break;

            // 숫자 입력
            numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 백트래킹 시작
            backtrack(0, 0);
            System.out.println(); // 테스트 케이스 사이 빈 줄용
    }
}
    static void backtrack(int start, int count) {
        // 6개 선택 완료
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(selected[i]);
                if (i < 5) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        // start부터 끝까지 시도
        for (int i = start; i < k; i++) {
            selected[count] = numbers[i];
            backtrack(i + 1, count + 1);
        }
    }
}
