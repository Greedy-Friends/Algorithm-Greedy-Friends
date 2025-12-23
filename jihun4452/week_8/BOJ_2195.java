import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();

		int count = 0;
		int i = 0;

		while (i < P.length()) {
			int maxLen = 0;

			// S의 시작점에서 매칭 시도
			for (int j = 0; j < S.length(); j++) {
				int len = 0;
				while (i + len < P.length() && j + len < S.length() && P.charAt(i + len) == S.charAt(j + len)) {
					len++;
				}
				maxLen = Math.max(maxLen, len);
			}

			i += maxLen;
			count++;
		}

		System.out.println(count);
	}
}