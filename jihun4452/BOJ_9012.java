import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			String line = br.readLine();
			sb.append(isVPS(line) ? "YES" : "NO").append('\n');
		}
		System.out.print(sb);
	}

	private static boolean isVPS(String s) {
		int cnt = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') cnt++;
			else cnt--;

			if (cnt < 0) return false;
		}
		return cnt == 0;
	}
}