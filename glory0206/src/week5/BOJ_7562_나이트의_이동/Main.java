package week5.BOJ_7562_나이트의_이동;

import java.util.*;
import java.io.*;

public class Main {
    static class Position{
        int x;
        int y;

        Position(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트 반복
        for(int i=0; i<T; i++) {
            int l = Integer.parseInt(br.readLine());

            // 체스판 생성
            map = new int[l][l];
            visited = new boolean[l][l];
            dist = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 현 나이트의 위치
            Position current = new Position(x, y);

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 나이트가 도착해야 할 목적지
            Position finish = new Position(x, y);

            System.out.println(bfs(current, finish));
        }
    }

    static int bfs(Position start, Position end){
        Queue<Position> queue = new LinkedList<>();

        queue.add(start);
        visited[start.x][start.y] = true;

        while(!queue.isEmpty()){
            Position current = queue.poll();

            if(current.x == end.x && current.y == end.y){
                return dist[current.x][current.y];
            }

            for(int i=0; i<8; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx<0 || ny<0 || nx>=map.length || ny>=map[0].length){ // 체스판을 벗어난다면
                    continue;
                }
                if(visited[nx][ny]){ // 이미 방문한 곳
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new Position(nx, ny));
                dist[nx][ny] = dist[current.x][current.y] + 1;
            }
        }
        return -1;
    }
}
