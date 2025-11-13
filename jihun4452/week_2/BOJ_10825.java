import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[][] arr = new String[n][4];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().split(" ");
		}

		Arrays.sort(arr, (a, b) -> {
			int korA = Integer.parseInt(a[1]);
			int engA = Integer.parseInt(a[2]);
			int mathA = Integer.parseInt(a[3]);
			int korB = Integer.parseInt(b[1]);
			int engB = Integer.parseInt(b[2]);
			int mathB = Integer.parseInt(b[3]);

			if (korA != korB) return korB - korA;
			if (engA != engB) return engA - engB;
			if (mathA != mathB) return mathB - mathA;
			return a[0].compareTo(b[0]);
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(arr[i][0]).append('\n');
		}

		System.out.print(sb);
	}
}
