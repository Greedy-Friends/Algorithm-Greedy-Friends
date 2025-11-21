package week3.BOJ_14503_로봇_청소기;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] room = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cleanCount = 0;

        while(true){
            if(room[r][c] == 0){
                room[r][c] = -1;
                cleanCount += 1;
            }
            boolean check = false;
            for(int i=0; i<4; i++){ // 4방면 확인
                int nx = r+dx[i];
                int ny = c+dy[i];
                if(room[nx][ny] == 0){
                    check = true;
                    break;
                }
            }
            if(check){ // 청소할 곳이 있다면
                d = (d+3) % 4; // 반시계방향으로 회전

                int nx = r+dx[d];
                int ny = c+dy[d];
                if(room[nx][ny] == 0){ // 이동
                    r = nx;
                    c = ny;
                }
            } else{ // 청소할 곳이 없다면
                int nx = r-dx[d];
                int ny = c-dy[d];
                if(room[nx][ny] != 1){ // 벽이 아니라면
                    r = nx;
                    c = ny;
                } else{ // 벽이면 기능 정지
                    break;
                }
            }
        }
        System.out.println(cleanCount);
    }
}
