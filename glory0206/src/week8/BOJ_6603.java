package week8;

import java.util.*;
import java.io.*;

public class BOJ_6603 {
    static int k;
    static int[] nums;
    static int[] numBox = new int[6]; // 선택된 6개
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 6) { // 6개가 쌓이면 stringbuilder에 추가
            for (int i = 0; i < 6; i++) {
                sb.append(numBox[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 순서대로 저장하다 6 이후로는 i는 그대로 진행, depth는 역행하는 흐름
        // 정답 코드를 보고도 이해하는데 시간이 걸렸다...
        // 연습이 많이 필요하겠다
        for (int i = start; i < k; i++) {
            numBox[depth] = nums[i];
            dfs(i + 1, depth + 1);
        }
    }
}
