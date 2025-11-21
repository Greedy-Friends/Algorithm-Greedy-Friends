// [BOJ] 14503: 로봇 청소기
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 방의 크기 n*m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 처음에 로봇 청소기가 있는 칸의 좌표 (r,c), 로봇 청소기가 바라보는 방향 d
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 각 장소의 상태를 나타내는 n*m
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상우하좌
        // d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽, 3인 경우 서쪽
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(true){
            // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            // 0 = 청소되지 않은 빈 칸, 1 = 벽, 2 = 청소 완료된 칸
            if(arr[x][y] == 0) arr[x][y] = 2;

            // 현재 칸의 주변 4칸 청소 여부 확인
            boolean hasDirty = false;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0){
                    hasDirty = true;
                    break;
                }
            }

            // 2. 청소되지 않은 빈 칸이 없는 경우
            // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if(!hasDirty){
                int bx = x - dx[d];
                int by = y - dy[d];

                if(bx >= 0 && bx < n && by >= 0 && by < m && arr[bx][by] != 1){
                    // 벽이 아닌 경우 한 칸 후진
                    x = bx;
                    y = by;
                } else {
                    break;  // 후진할 수 없다면 while문 break(작동 중지)
                }
            }

            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            // 반시계 방향으로 90도 회전 = 시계 방향으로 270도 회전
            // 시계 방향 90도마다 +1 -> 270도 회전이므로 +3
            if(hasDirty){
                d = (d + 3) % 4;
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                // 1번으로 돌아간다.
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0){
                    // 빈 칸인 경우 한 칸 전진
                    x = nx;
                    y = ny;
                }
            }
        }

        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 2){ // 2 = 청소 완료된 칸
                    result++;
                }
            }
        }

        System.out.print(result);
    }
}