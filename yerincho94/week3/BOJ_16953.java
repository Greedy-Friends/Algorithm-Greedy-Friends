package week3;

import java.util.*;
import java.io.*;

/*
    시작 수 A에서 출발해서, 연산 두 가지 중 아무거나 골라서 반복 적용하면 B를 만들 수 있을까?
    만들 수 있다면, 그 과정의 최소 연산 횟수는 얼마인가?

    아이디어 : B가 짝수이면 B / 2, 끝자리가 1이면 1 제거
*/

// A -> B (실버2)
public class BOJ_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split(" ");
        int A = Integer.parseInt(N[0]);
        int B = Integer.parseInt(N[1]);

        int count = 1; // 최종 포함해서 누적용
        while(B > A) {
            if(B % 2 == 0) { // 짝수일경우
                B = B / 2;
                count++;
            } else if (B % 10 == 1) {
                B = B / 10;
                count++;
            } else {
                count = -1;
                break;
            }
        }
        if(B != A) {
            count = -1;
        }
        System.out.println(count);
    }
}
