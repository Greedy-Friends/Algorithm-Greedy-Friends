// [BOJ] 16953: A → B
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int count = 1;

        while (target > start){
            if(target % 10 == 1){ // 일의 자리가 1인 경우
                target = (target - 1) / 10;
                count++;
                continue;
            } else if(target % 2 == 0){ // 짝수인 경우
                target /= 2;
                count++;
                continue;
            } else { // 더 이상 연산이 불가능하므로 break
                break;
            }
        }

        if(target == start) System.out.print(count);
        else System.out.print(-1);
    }
}