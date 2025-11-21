package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 1. 왼쪽 회전
 북(0) → 서(3)
 동(1) → 북(0)
 남(2) → 동(1)
 서(3) → 남(2)

 공식: (방향 + 3) % 4 <- 음수를 방지하기 위해서 나온 공식
 ex) (0 + 3) % 4 = 3 % 4 = 3
     (1 + 3) % 4 = 4 % 4 = 0

 2. 후진
 북(0)일 때 후진 = 남(2) 방향 한 칸
 동(1)일 때 후진 = 서(3) 방향 한 칸

 공식: 반대 방향 = (방향 + 2) % 4
 */

// 로봇 청소기 (골드5)
public class BOJ_14503 {
    // 방향 : 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0}; // 행의 변화 (북, 동, 남, 서)
    static int[] dy = {0, 1, 0, -1}; // 열의 변화 (북, 동, 남, 서)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 로봇 현재위치 : 행
        int c = Integer.parseInt(st.nextToken()); // 로봇 현재위치 : 열
        int d = Integer.parseInt(st.nextToken()); // 방향

        // 방 현상황 저장
        int[][] room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 현재 칸 청소하기 시작
        int cleanedCnt = 0; // 청소한 칸 개수 누적용

        while (true) {
            // 현재 칸 청소
            if(room[r][c] == 0) {
             room[r][c] = -1; // 청소 완료로 표시
             cleanedCnt++;
            }

            // 주변 4칸 중 청소할 곳이 있는지 확인
            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if(room[nx][ny] == 0) {
                    cleaned = true;
                    break;
                }
            }

            if(cleaned) {
                // 청소할 곳이 있으면 왼쪽으로 회전
                d = (d + 3) % 4;

                // 왼쪽 칸 확인
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 왼쪽 칸이 청소 안된 빈 칸이면 그 칸으로 이동
                if(room[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }
            } else {
                // 청소할 곳 없으면 후진
                int back = (d + 2) % 4;
                int bx = r + dx[back];
                int by = c + dy[back];

                if(room[bx][by] == 1) {
                    break; // 작동 종료
                }

                // 후진
                r = bx;
                c = by;
            }
        }
        System.out.println(cleanedCnt);
    }
}
