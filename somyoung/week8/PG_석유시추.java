// PG / 석유 시추 / Lv. 2
package somyoung.week8;

import java.util.*;

class PG_석유시추 {
    public static int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        // 상우하좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[] colSum = new int[m]; // 열별로 뚫었을 때 얻는 석유량 리스트

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    Set<Integer> cols = new HashSet<>(); // 이 석유 덩어리가 걸친 열 인덱스 집합

                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    cols.add(j);
                    int oil = 1;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];

                            if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                                oil++;
                                cols.add(ny);
                            }
                        }
                    }

                    for (int col : cols) {
                        colSum[col] += oil; // 각 col에 oil 누적
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, colSum[i]);
        }

        return max;
    }

    // 테스트 케이스
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
        System.out.println(solution(new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}}));
    }
}
