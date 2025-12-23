import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] small = new int[N];
		int[] big = new int[N];

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			small[i] = Integer.parseInt(st.nextToken());
			big[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine().trim());

		int[][] dp = new int[N + 1][2];
		int maxb = Integer.MAX_VALUE / 2;

		for (int i = 0; i <= N; i++) {
			dp[i][0] = maxb;
			dp[i][1] = maxb;
		}

		dp[1][0] = 0;

		for (int i = 1; i < N; i++) {
			if (i + 1 <= N) {
				dp[i + 1][0] = Math.min(dp[i + 1][0], dp[i][0] + small[i]);
				dp[i + 1][1] = Math.min(dp[i + 1][1], dp[i][1] + small[i]);
			}

			if (i + 2 <= N) {
				dp[i + 2][0] = Math.min(dp[i + 2][0], dp[i][0] + big[i]);
				dp[i + 2][1] = Math.min(dp[i + 2][1], dp[i][1] + big[i]);
			}

			if (i + 3 <= N) {
				dp[i + 3][1] = Math.min(dp[i + 3][1], dp[i][0] + K);
			}
		}

		System.out.println(Math.min(dp[N][0], dp[N][1]));
	}
}