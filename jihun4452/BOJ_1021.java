import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		st = new StringTokenizer(br.readLine());
		int[] targets = new int[M];
		for (int i = 0; i < M; i++) {
			targets[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0; //다 더한거

		// 이제 하나씩 뽑아보자.
		for (int target : targets) {

			int idx = deque.indexOf(target);

			// 왼쪽이랑 오른쪽 더 적은거 골라서함
			int left = idx;
			int right = deque.size() - idx;

			// 왼쪽이 더 빠르면 일로 돌려?? ?
			if (left <= right) {
				for (int i = 0; i < left; i++) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			}
			// 오른쪽으로 돌림 아니면
			else {
				for (int i = 0; i < right; i++) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}
			// 왔으니까 빼주고,,
			deque.pollFirst();
		}
		System.out.println(count);
	}
}
