// BOJ / 6603 / 로또 / 실버2
package somyoung.week8;

import java.io.*;
import java.util.*;

public class BOJ_6603 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<int[]> testCase = new ArrayList<>();

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) break; // 0을 만나면 입력 탈출

            StringTokenizer st = new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            int[] lotto = new int[k];

            for (int i = 0; i < k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }

            testCase.add(lotto);
        }

        for (int i = 0; i < testCase.size(); i++) {
            int[] lotto = testCase.get(i);

            // 중복 없는 조합
            dfs(0, 0, lotto, lotto.length, new int[6]); // depth, start, 집합 S, k, output

            if (i != testCase.size() - 1) sb.append('\n'); // 테스트케이스 사이 빈 줄
        }

        System.out.print(sb.toString());
    }

    public static void dfs(int depth, int start, int[] S, int k, int[] output) {
        if (depth == 6) { // 수 6개를 골랐을 때, 출력
            for (int num : output) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            output[depth] = S[i];
            dfs(depth + 1, i + 1, S, k, output);
        }
    }
}