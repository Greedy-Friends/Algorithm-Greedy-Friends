// [BOJ] 20365: 블로그2
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] colors = br.readLine().toCharArray();

        int red = 0;
        int blue = 0;

        // 1. 첫 문자 기준 한 가지 색으로 모두 칠하기
        if(colors[0] == 'R') red++;
        else blue++;

        for(int i=1; i<n; i++){
            char current = colors[i];

            // 2. 배열을 탐색하며 색이 바뀌면 해당 색깔 블록 수 증가
            if(current != colors[i-1]){
                if(current == 'R') red++;
                else blue++;
            }
        }

        // 3. 더 적은 색깔의 블록 수 + 1(처음에 전체 칠한 작업)
        System.out.print(Math.min(red, blue) + 1);
    }
}