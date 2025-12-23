import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] selected = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			if (k == 0) break;

			if (!first) sb.append("\n");
			first = false;

			arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);
		}

		System.out.print(sb);
	}

	static void combination(int start, int depth) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(selected[i]);
				if (i < 5) sb.append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < arr.length; i++) {
			selected[depth] = arr[i];
			combination(i + 1, depth + 1);
		}
	}
}