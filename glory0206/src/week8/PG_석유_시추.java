package week8;

import java.util.*;

class PG_석유_시추 {
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int[] lines;

    public int solution(int[][] land) {
        n = land.length; // 세로길이
        m = land[0].length; // 가로길이
        map = land;
        visited = new boolean[n][m];
        lines = new int[m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && !visited[i][j]){ // 석유가 존재하면서, 방문하지 않았다면
                    bfs(i, j);
                }
            }
        }
        int answer = 0;
        for(int total: lines){
            answer = Math.max(answer, total);
        }
        return answer;
    }
    static private void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int size = 0; // 석유 덩어리의 크기
        Set<Integer> columnIndex = new HashSet<>(); // 석유 덩어리가 존재하는 모든 열

        while(!queue.isEmpty()){
            int[] currentSpot = queue.poll();
            size++;
            columnIndex.add(currentSpot[1]);

            for(int i=0; i<4; i++){
                int nx = currentSpot[0] + dx[i];
                int ny = currentSpot[1] + dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=m){ // 범위를 벗어난다면
                    continue;
                }
                if(visited[nx][ny] || map[nx][ny] == 0){ // 이미 방문 했거나 석유가 없다면
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        for(int column: columnIndex){
            lines[column] += size;
        }
    }
}