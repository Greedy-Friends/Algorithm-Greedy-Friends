import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/31846

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken());

            // 끝부터 1식 증가시면서 접기... 길이가 5면 [4, 1] [3, 2] [2, 3] [1, 4] 역순 정순
            String sub = str.substring(l,r);
            int max = 0;
            int cnt = 0;
            for(int j = 1; j < sub.length(); j++) {
                cnt = 0;
                String right = sub.substring(sub.length() - j );
                String left = sub.substring(0, sub.length() - j);
                int len = Math.min(left.length(), j); // left가 더 짧아졌을 때 방지

                for(int k = 0; k < len; k++) { // 역순 정순 ** 굳이 2중for문으로 안해도 가능 **
                    char leftChar = left.charAt(left.length() - 1 - k);
                    char rightChar = right.charAt(k);

                    if(leftChar == rightChar) cnt++;
                }
                max = Math.max(max, cnt);
            }

            System.out.println(max);

        }

    }
}
