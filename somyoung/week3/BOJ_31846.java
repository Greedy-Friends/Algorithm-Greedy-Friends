// [BOJ] 31846: 문자열 접기
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_31846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        for(int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 0-index-base 이므로 - 1
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int score = 0;

            // 접히는 경계 범위 l ~ r-1
            for(int fold=l; fold<r; fold++){
                int left = fold;
                int right = fold+1;
                int temp = 0;

                while(l <= left && right <= r){ // 범위 체크 l ~ r
                    if(str.charAt(left) == str.charAt(right)){
                        temp++;
                    }
                    left--;
                    right++;
                }
                // 최대 값 갱신
                score = Math.max(score, temp);
            }

            System.out.println(score);
        }
    }
}