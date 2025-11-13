import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] line = new int[N];
		for (int i = 0; i < N; i++) line[i] = Integer.parseInt(st.nextToken());

		int[] stack = new int[N];
		int top = -1;

		int expected = 1;
		int idx = 0;

		while (idx < N || top >= 0) {
			if (idx < N && line[idx] == expected) {
				idx++;
				expected++;
			} else if (top >= 0 && stack[top] == expected) {
				top--;
				expected++;
			} else if (idx < N) {
				stack[++top] = line[idx++];
			} else {
				break;
			}
		}

		System.out.print(expected == N + 1 ? "Nice" : "Sad");
	}
}
