import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/16953

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 2가지 A = A * 2 or A = (A * 10) + 1;
        int B = Integer.parseInt(st.nextToken());

        int cur = B;
        int cnt = 0;
        // 역산 B에서 부터 /2 /10....
        while(cur > A) {
            if(cur == A) break;

            if(cur % 10 == 1) {
                cur = (cur - 1) / 10;
                cnt++;
            }
            else if(cur % 2 == 0) {
                cur /= 2;
                cnt++;
            }
            else break;

        }
        if(cur == A) System.out.println(cnt + 1);
        else System.out.println(-1);

    }
}
