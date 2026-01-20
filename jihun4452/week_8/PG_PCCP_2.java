import java.util.*;

// 석유 시추
class Solution {
	int n, m;
	int[][] land;
	int[][] groupId;
	Map<Integer, Integer> groupSize;
	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};

	public int solution(int[][] land) {
		this.land = land;
		this.n = land.length;
		this.m = land[0].length;
		this.groupId = new int[n][m];
		this.groupSize = new HashMap<>();

		int id = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (land[i][j] == 1 && groupId[i][j] == 0) {
					int size = bfs(i, j, id);
					groupSize.put(id, size);
					id++;
				}
			}
		}

		int maxOil = 0;
		for (int col = 0; col < m; col++) {
			Set<Integer> passedGroups = new HashSet<>();
			for (int row = 0; row < n; row++) {
				if (groupId[row][col] > 0) {
					passedGroups.add(groupId[row][col]);
				}
			}

			int totalOil = 0;
			for (int gid : passedGroups) {
				totalOil += groupSize.get(gid);
			}
			maxOil = Math.max(maxOil, totalOil);
		}

		return maxOil;
	}

	private int bfs(int startX, int startY, int id) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{startX, startY});
		groupId[startX][startY] = id;
		int size = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m
					&& land[nx][ny] == 1 && groupId[nx][ny] == 0) {
					groupId[nx][ny] = id;
					queue.offer(new int[]{nx, ny});
					size++;
				}
			}
		}
		return size;
	}
}
