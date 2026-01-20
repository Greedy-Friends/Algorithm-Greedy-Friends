package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 돌이 일렬로 있음
 *
 * 점프 3가지:
 * 1. 작은 점프: 1칸 → 에너지 소모
 * 2. 큰 점프: 2칸 → 에너지 소모
 * 3. 매우 큰 점프: 3칸 → K 에너지 소모 (딱 1번만 가능)
 *
 * 1번 돌 → N번 돌까지 가는 최소 에너지는?
 *
 * 포도주 시식과 비슷함:
 * - 선택의 경우의 수
 * - 이전 상태 참조
 * - 최솟값/최댓값 구하기
 */
// 징검다리 건너기(실버1) - DP
public class BOJ_21317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 에너지 저장
        int[] small = new int[N];  // 작은 점프
        int[] big = new int[N];    // 큰 점프

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        int[] dp = new int[N]; // dp[i] = i번 돌까지 가는 최소 에너지 (3칸 점프 X)
        int[] dpWith3 = new int[N]; // dpWith3[i] = i번 돌까지 가는 최소 에너지 (3칸 점프 O)

        dp[0] = 0;  // 시작점
        dpWith3[0] = 0;

        if (N > 1) {
            dp[1] = small[0];
            dpWith3[1] = small[0];
        }

        if (N > 2) {
            dp[2] = Math.min(small[0] + small[1], big[0]);
            dpWith3[2] = Math.min(small[0] + small[1], big[0]);
        }

        for (int i = 3; i < N; i++) {
            // 3칸 점프 안 쓴 경우
            dp[i] = Math.min(
                    dp[i-1] + small[i-1],  // 1칸 점프
                    dp[i-2] + big[i-2]     // 2칸 점프
            );

            // 3칸 점프 쓴 경우
            dpWith3[i] = Math.min(
                    // i-3에서 3칸 점프
                    dp[i-3] + K,
                    // 이전에 이미 3칸 점프 사용
                    Math.min(
                            dpWith3[i-1] + small[i-1],
                            dpWith3[i-2] + big[i-2]
                    )
            );
        }

        // 두 경우 중 최소
        System.out.println(Math.min(dp[N-1], dpWith3[N-1]));
    }
}
