import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/21317

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[][] step = new int[N ][2];
        int[][] dp = new int[N + 1][2];

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            step[i][0] = Integer.parseInt(st.nextToken());
            step[i][1] = Integer.parseInt(st.nextToken());
        }
        int jump = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 100000); // 적당히 큰값 넣어 놓기
        }

        dp[1][0] = 0;
        if (N >= 2) dp[2][0] = step[1][0];
        if (N >= 3) dp[3][0] = Math.min(step[1][0] + step[2][0], step[1][1]);

        for(int i = 4; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + step[i - 1][0],
                    dp[i - 2][0] + step[i - 2][1]); // 필살 점프 안했을 때,
            dp[i][1] = Math.min(dp[i - 3][0] + jump,
                    Math.min(dp[i - 1][1] + step[i - 1][0],
                            dp[i - 2][1] + step[i - 2][1])); // 했을 때,
        }
        int answer = Math.min(dp[N][0], dp[N][1]);
        System.out.println(answer);

    }
}
