import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int min = 256, max = 0;

		// 맵 입력받으면서 최소 최대 높이 체크
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}

		int ansTime = Integer.MAX_VALUE;
		int ansHeight = 0;

		// 가능한 높이 전부 시도
		for (int h = min; h <= max; h++) {
			int remove = 0;// 제거할 블록
			int add = 0;// 추가할 블록

			// 높이 맞추기 계산
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int diff = map[i][j] - h;

					if (diff > 0) remove += diff;
					else add -= diff;
				}
			}

			// 인벤토리 부족하면 불가능
			if (remove + B < add) continue;

			// 시간 계산
			int time = remove * 2 + add;

			// 최소 시간 더 높은 높이 우선
			if (time < ansTime || (time == ansTime && h > ansHeight)) {
				ansTime = time;
				ansHeight = h;
			}
		}

		System.out.println(ansTime + " " + ansHeight);
	}
}
