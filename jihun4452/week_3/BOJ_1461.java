import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		// 왼쪽/오른쪽으로 분리
		for (int i = 0; i < N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			if (pos < 0) {
				left.add(Math.abs(pos));
			} else {
				right.add(pos);
			}
		}

		Collections.sort(left, Collections.reverseOrder());
		Collections.sort(right, Collections.reverseOrder());

		// 마지막에 돌아오지 않을 가장 먼 거리
		int maxDist = 0;
		if (!left.isEmpty()) {
			maxDist = Math.max(maxDist, left.get(0));
		}
		if (!right.isEmpty()) {
			maxDist = Math.max(maxDist, right.get(0));
		}

		int total = 0;

		// 각 방향에서 M권씩 묶어서 왕복 처리
		for (int i = 0; i < left.size(); i += M) {
			total += left.get(i) * 2;
		}
		for (int i = 0; i < right.size(); i += M) {
			total += right.get(i) * 2;
		}

		total -= maxDist; // 가장 먼 거리만 편도 처리

		System.out.println(total);
	}
}
