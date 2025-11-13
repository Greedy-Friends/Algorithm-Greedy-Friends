import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		while (pq.size() > 1) {
			// 가장 작은 두 묶음 합침
			int first = pq.poll();
			int second = pq.poll();

			int sum = first + second;
			result += sum;
			pq.add(sum); // 합친 묶음 다시 넣음
		}

		System.out.println(result);
	}
}
