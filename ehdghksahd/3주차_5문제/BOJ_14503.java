import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/14503

public class Main {
    private final static int[] dx = {0, 1, 0, -1};
    private final static int[] dy = {-1, 0, 1, 0}; // 위 오 아 왼

    public static class Robo {
        private int pos[]; // 현 위치
        private int dir; // 바라보는 방향 0 -> 3 북 동 남 서
        private boolean run;
        private int work;

        Robo(int pos[], int dir, boolean run, int work) {
            this.pos = pos;
            this.dir = dir;
            this.run = run;
            this.work = work;
        }

        public boolean search(int[][] map, int N, int M) {
            for (int i = 0; i < 4; i++) {
                int x = this.pos[1] + dx[i];
                int y = this.pos[0] + dy[i];

                if (x >= 0 && y >= 0 && x < M && y < N) {
                    if (map[y][x] == 0) return true;
                }
            }
            return false;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Robo robo = new Robo(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}
                , Integer.parseInt(st.nextToken()), true, 0);
        int map[][] = new int[N][M]; // 방 크기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (robo.run) {
            int posX = robo.pos[1];
            int posY = robo.pos[0];

            if (map[posY][posX] == 0) {
                map[posY][posX] += 2;
                robo.work++;
            }
            if (robo.search(map, N, M)) {
                int tmp = 0;
                boolean move = false;

                while (tmp < 4) {
                    robo.dir = (robo.dir + 3) % 4; // 북 동 남 서

                    int x = robo.pos[1] + dx[robo.dir];
                    int y = robo.pos[0] + dy[robo.dir];

                    if (x >= 0 && y >= 0 && x < M && y < N && map[y][x] == 0) {
                        robo.pos[1] = x;
                        robo.pos[0] = y;
                        move = true;
                        break;
                    }
                    tmp++;
                }
                if(move) continue;
            }

            int backDir = (robo.dir + 2) % 4; // 후진
            int bx = posX + dx[backDir];
            int by = posY + dy[backDir];

            if (bx >= 0 && by >= 0 && bx < M && by < N && map[by][bx] != 1) {
                robo.pos[1] = bx;
                robo.pos[0] = by;
            }
            else robo.run = false;
        }
        System.out.println(robo.work);
    }
}
