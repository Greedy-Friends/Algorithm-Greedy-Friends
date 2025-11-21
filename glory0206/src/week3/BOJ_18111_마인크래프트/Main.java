package week3.BOJ_18111_마인크래프트;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int maxH = 0;
        int minH = 256;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, ground[i][j]);
                minH = Math.min(minH, ground[i][j]);
            }
        }

        int bestTime = Integer.MAX_VALUE; // Integer에서 가장 큰 수
        int bestHeight = 0;

        for(int h=minH; h<=maxH; h++){ // 평탄화 시도를 할 수 있는 모든 높이
            int time = 0;
            int inventory = B;

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    int diff = ground[i][j] - h;

                    if(diff>0){ // 1번 작업(블록 캐기)
                        time += diff*2;
                        inventory += diff;
                    } else if(diff<0){ // 2번 작업(블록 놓기)
                        time += (-diff); // diff의 값이 음수이기 때문에 -를 붙여줌
                        inventory -= (-diff);
                    }
                }
            }
            if(inventory < 0){ // 해당 층에서 모든 작업을 마쳤을 때, 인벤이 0 미만이라면 블록이 부족하다는 뜻으로 불가능을 의미
                continue;
            }
            if (time < bestTime || (time == bestTime && h > bestHeight)) {
                bestTime = time;
                bestHeight = h;
            }
        }
        System.out.println(bestTime + " " + bestHeight);
    }
}
