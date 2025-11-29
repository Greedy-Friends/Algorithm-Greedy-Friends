package week5.BOJ_14501_퇴사;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];

        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];

        for(int i=N; i>0; i--){
            // 상담이 퇴사일을 넘기지 않는 경우
            if(N+1 >= i+T[i]){
                // 현재 위치에서의 가장 높은 수익
                // 현재 상담의 수익과 이 상담이 끝났을 때 시작한 상담의 최대 수익 VS 이 상담을 포기하고 다음 날짜로부터의 최대 수익
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i+1]);
            }else{
                dp[i] = dp[i+1];
            }
        }
        System.out.println(dp[1]);
    }
}
