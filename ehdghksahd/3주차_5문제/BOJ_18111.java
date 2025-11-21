import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/18111

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int min = 257;
        int max = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        int resultT = Integer.MAX_VALUE; // 최소 시간
        int resultH = 0; // 최종 높이
        for(int h = max; h >= min; h--) { // 높은거 부터 해서 땅 높이 가장 높은거 처리
            int remove = 0;
            int place = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    int cur = map[i][j];

                    if(cur > h) remove += cur - h; // 높으면 제거
                    else if(cur < h) place += h - cur; // 낮으면 설치
                }
            }
            if(B + remove >= place) { // 인벤 + 제거한 블록 >= 설치한 블록
                int time = (remove * 2) + place;

                if(time < resultT) {
                    resultT = time;
                    resultH = h;
                }
            }
        }
        System.out.println(resultT + " " +resultH);
    }
}
