package week8;

import java.util.*;
import java.io.*;

public class BOJ_21317{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 돌의 수

        if(N==1){
            System.out.println(0);
            return;
        }

        int[][] energy = new int[N+1][2]; // [][0]: 작은 점프, [][1]: 큰 점프

        // 작은 점프, 큰 점프 에너지 소모
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken()); // 작은 점프
            energy[i][1] = Integer.parseInt(st.nextToken()); // 큰 점프
        }
        int K = Integer.parseInt(br.readLine()); // 슈퍼 점프 에너지 소모

        int[][] dp = new int[2][N+1]; // [0][]: 슈퍼 점프 미사용, [1][]: 슈퍼 점프 사용

        // 작은 수 비교를 위해 최대 조건의 수로 초기화
        int E = 1000000; // N(20) * 최대에너지(5000) 보다 큰 값
        Arrays.fill(dp[0], E);
        Arrays.fill(dp[1], E);

        dp[0][1] = 0; // 첫 위치(아직 아무 동작 하지 않음)

        for (int i = 1; i < N; i++) {
            // 슈퍼 점프 미사용
            if (i + 1 <= N) { // 작은 점프를 해도 최종 바위를 넘어서지 않는다면
                dp[0][i + 1] = Math.min(dp[0][i + 1], dp[0][i] + energy[i][0]);
            }
            if (i + 2 <= N) { // 큰 점프를 해도 최종 바위를 넘어서지 않는다면
                dp[0][i + 2] = Math.min(dp[0][i + 2], dp[0][i] + energy[i][1]);
            }

            // 슈퍼 점프 사용
            if (i + 1 <= N) { // 작은 점프를 해도 최종 바위를 넘어서지 않는다면
                dp[1][i + 1] = Math.min(dp[1][i + 1], dp[1][i] + energy[i][0]);
            }
            if (i + 2 <= N) { // 큰 점프를 해도 최종 바위를 넘어서지 않는다면
                dp[1][i + 2] = Math.min(dp[1][i + 2], dp[1][i] + energy[i][1]);
            }

            if (i + 3 <= N) { // 슈퍼 점프 사용
                dp[1][i + 3] = Math.min(dp[1][i + 3], dp[0][i] + K);
            }
        }
        int answer = Math.min(dp[0][N], dp[1][N]);
        System.out.println(answer);
    }
}
