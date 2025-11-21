import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 문자열이 적힌 종이를 한 번 접을 수 있음
		 * 접었을 때 맞닿는 같은 문자 개수가 점수가 됨
		 * 구간 [l, r]이 주어지면 그 구간에서 최대 점수를 구해야 함
		 * Q개의 쿼리를 처리해야 함
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 전체 문자열 길이
		String s = br.readLine();
		int q = Integer.parseInt(br.readLine()); // 쿼리 개수

		for (int query = 0; query < q; query++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;

			int maxScore = 0;

			for (int foldPos = l; foldPos < r; foldPos++) {
				int score = 0;

				int leftLen = foldPos - l + 1;
				int rightLen = r - foldPos;

				int compareLen = Math.min(leftLen, rightLen);

				// 접었을 때 맞닿는 문자들 비교
				for (int i = 0; i < compareLen; i++) {
					// 왼쪽은 접는 위치에서 왼쪽으로 한 칸씩
					// 오른쪽은 접는 위치+1에서 오른쪽으로 한 칸씩
					char leftChar = s.charAt(foldPos - i);
					char rightChar = s.charAt(foldPos + 1 + i);

					if (leftChar == rightChar) {
						score++; // 같으면 1점 획득
					}
				}

				if (score > maxScore) {
					maxScore = score;
				}
			}

			sb.append(maxScore).append("\n");
		}

		System.out.print(sb);
	}
}