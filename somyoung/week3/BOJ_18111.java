// [BOJ] 18111: 마인크래프트
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        // 최소 높이, 최대 높이 갱신
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                minHeight = Math.min(minHeight, arr[i][j]);
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int height = 0;

        // 최소 높이 ~ 최대 높이 탐색하면서 최소 시간/높이 찾기
        for(int h=minHeight; h<=maxHeight; h++){
            int time = 0;
            int inventory = b;

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    int cur = arr[i][j];

                    // h -> 기준 높이
                    if(cur < h){ // 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. -- 1초
                        inventory -= (h - cur);
                        time += (h - cur);
                    } else if (cur > h){ // 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. -- 2초
                        inventory += (cur - h);
                        time += (2 * (cur - h));
                    }
                }
            }

            // 인벤토리에 남은 블록 갯수가 음수라면, 최소 시간 갱신하지 않고 continue
            if(inventory < 0) continue;

            // 최소 시간 갱신, 높이 갱신
            minTime = Math.min(minTime, time);
            if(minTime == time) height = h;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minTime).append(' ').append(height);
        System.out.print(sb.toString());
    }
}