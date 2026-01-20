import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/250136
// 석유 시추

class Solution {
    public int[] dr = {-1, 1, 0, 0};
    public int[] dc = {0, 0, -1, 1};

    public void BFS(int[] start, int[][] land, boolean[][] visited, int[] sumCol){

        int size = 0;
        int r = start[0];
        int c = start[1];

        Queue<int[]> q = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        q.offer(start);
        visited[r][c] = true;



        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            size++;

            set.add(cur[1]);

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length) {
                    if(!visited[nr][nc] && land[nr][nc] == 1) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {nr, nc});
                    }
                }
            }
        }
        for(int col : set) sumCol[col] += size;
    }

    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 세로
        int m = land[0].length; // 가로
        boolean[][] visited = new boolean[n][m];
        int[] sumCol = new int[m]; // 열 마다 석유덩어리들 저장 -> 이거 생각하기가 어려웠다...


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && land[i][j] == 1)
                    BFS(new int[]{i, j}, land, visited, sumCol);
            }
        }

        for(int num : sumCol) answer = Math.max(answer, num);


        return answer;
    }
}