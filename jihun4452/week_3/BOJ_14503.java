import java.io.*;
import java.util.*;

public class Main {
	// 양옆 위아래
	/**
	 * 이번건 지피티에게 도움을 좀 받았습니다 ㅠㅠ
	 */
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	static int N, M;
	static int[][] room;
	static int r, c, d;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean();
		System.out.println(count);
	}

	static void clean() {
		while (true) {
			if (room[r][c] == 0) {
				room[r][c] = 2; // 청소 완료 표시
				count++;
			}

			// 주변 4칸 중 청소되지 않은 빈 칸이 있는지 확인
			boolean hasDirty = false;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				// 범위 체크 및 청소되지 않은 빈 칸 확인
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (room[nr][nc] == 0) {
						hasDirty = true;
						break;
					}
				}
			}

			if (hasDirty) {
				// 반시계 방향으로 90도 회전
				d = (d + 3) % 4;

				// 바라보는 방향을 기준으로 앞쪽 칸 확인
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && room[nr][nc] == 0) {
					r = nr;
					c = nc;
				}
			} else {
				// 바라보는 방향을 유지한 채로 한 칸 후진
				int br = r - dr[d];
				int bc = c - dc[d];

				// 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
				if (br >= 0 && br < N && bc >= 0 && bc < M && room[br][bc] != 1) {
					r = br;
					c = bc;
				} else {
					break;
				}
			}
		}
	}
}