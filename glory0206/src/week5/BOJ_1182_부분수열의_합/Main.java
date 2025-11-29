package week5.BOJ_1182_부분수열의_합;

import java.util.*;
import java.io.*;

public class Main {
    static int N, S, count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 목표 값

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0);

        if(S == 0){ // S가 0이라면 아무것도 선택하지 않았을 경우도 포함하게 됨
            count--;
        }
        System.out.println(count);
    }

    static void dfs(int idx, int sum){
        // 마지막 숫자까지의 경우를 모두 확인 후
        if(idx == N){
            if(sum == S){ // 목표값과 일치한다면
                count++;
            }
            return;
        }
        // 현재 숫자를 더해줌
        dfs(idx+1, sum+arr[idx]);

        // 현재 숫자 선택하지 않고 넘어감
        dfs(idx+1, sum);
    }
}
