import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] tree = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}

		int[] parent = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : tree[now]) {
				if (parent[next] == 0 && next != 1) {
					parent[next] = now;
					q.add(next);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) sb.append(parent[i]).append('\n');
		System.out.print(sb);
	}
}
