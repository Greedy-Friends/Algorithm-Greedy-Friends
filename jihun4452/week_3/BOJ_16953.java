import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int count = 1;

		while (B != A) {
			if (B < A) {
				System.out.println(-1);
				return;
			}

			if (B % 10 == 1) {
				B /= 10;
				count++;
			}
			else if (B % 2 == 0) {
				B /= 2;
				count++;
			}
			else {
				System.out.println(-1);
				return;
			}
		}

		System.out.println(count);
	}
}
