import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());

			// 0이면 최근 수를 지운다
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);// 0이 아니면 스택에 추가
			}
		}

		// 남은 숫자 모두 Sum에 넣음
		int sum = 0;
		for (int n : stack) {
			sum += n;
		}

		System.out.println(sum);
	}
}
