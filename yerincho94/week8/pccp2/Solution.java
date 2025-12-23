package week8.pccp2;

import java.util.*;

/**
 * 땅을 세로로 시추해서 석유 최대한 많이 캐기
 *
 * - n × m 격자 (land)
 * - 1: 석유, 0: 빈 땅
 * - 연결된 석유 = 하나의 덩어리
 * - 세로로 한 줄 시추 → 그 열의 모든 석유 덩어리 획득
 *
 * 가장 많은 석유를 얻을 수 있는 시추 위치는?
 *
 * Thinking :
 * 1. BFS로 모든 석유 덩어리 찾기
 * 2. 각 덩어리에 번호 부여 + 크기 저장
 * 3. 각 열마다 어떤 덩어리들이 있는지 확인
 * 4. 각 열의 석유량 = 그 열의 모든 덩어리 크기 합
 * 5. 최댓값 반환
 */
// https://school.programmers.co.kr/learn/courses/30/lessons/250136
// [PCCP 기출문제] 2번 / 석유 시추
class Solution {
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    static int n, m; // n: 행 개수, m: 열 개수
    static int[][] group; // (i,j) 위치의 석유 덩어리 번호
    static Map<Integer, Integer> groupSize; // 해당 덩어리의 석유 개수

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;

        group = new int[n][m]; // 덩어리 번호 저장용
        groupSize = new HashMap<>(); // 덩어리 크기 저장용

        int groupNum = 1; // 1번부터 시작

        // 1. 모든 석유 덩어리 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && group[i][j] == 0) { // 석유가1이고, 아직 방문 안한곳
                    int size = bfs(land, i, j, groupNum);
                    groupSize.put(groupNum, size); // 덩어리 크기 저장
                    groupNum++;
                }
            }
        }

        // 2. 각 열의 석유량 계산
        int maxOil = 0; // 최대 석유량

        for (int col = 0; col < m; col++) {
            Set<Integer> groups = new HashSet<>(); // 열에 있는 덩어리 번호들(중복 제거용)

            for (int row = 0; row < n; row++) {
                if (group[row][col] != 0) { // 석유가 있는 칸이면
                    groups.add(group[row][col]); // set이라서 자동 중복 제거
                }
            }

            int oil = 0; // 총 석유량 계산
            for (int g : groups) {
                oil += groupSize.get(g);
            }
            maxOil = Math.max(maxOil, oil); // 최대값 갱신
        }

        return maxOil;
    }

    static int bfs(int[][] land, int startX, int startY, int groupNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        group[startX][startY] = groupNum; // 시작점에 덩어리 번호 표시

        int size = 1; // 시작점 포함이므로 1부터

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 각자 밖이면 스킵
                if (land[nx][ny] == 0) continue; // 석유가 아니면 스킵
                if (group[nx][ny] != 0) continue; // 이미 방문했으면 스킵

                group[nx][ny] = groupNum;
                queue.offer(new int[]{nx, ny});
                size++;
            }
        }
        return size; // 총 크기 리턴
    }
}
