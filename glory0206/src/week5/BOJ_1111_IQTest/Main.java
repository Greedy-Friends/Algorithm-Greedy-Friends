package week5.BOJ_1111_IQTest;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자가 하나면 그 다음 수는 어떤 수든 나올 수 있다.
        if (N == 1) {
            System.out.println("A");
            return;
        }

        // 숫자가 2개면 사이에 있는 경우의 수가 너무 많다.
        if (N == 2) {
            if (arr[0] == arr[1]) System.out.println(arr[0]);
            else System.out.println("A");
            return;
        }

        int one = arr[0], two = arr[1], three = arr[2];
        int a = 0;
        if(one != two) { // 변화가 있음
            if((three - two) % (two - one) != 0) { // 숫자 간의 차이가 딱 나눠져 떨어지지 않을 경우 규칙이 없음을 알 수 있음
                System.out.println("B");
                return;
            }
            a = (three - two) / (two - one);
        } else{ // 첫 숫자와 다음 숫자가 같은 경우
            if(two != three){ // 그런데 두번 째와 세번 째가 다르면 이상을 알 수 있음
                System.out.println("B");
                return;
            }
        }

        int b = two - one * a;

        for (int i = 0; i < N - 1; i++) { // 모두 확인해보며 규칙을 따르지 않을 시
            if (arr[i] * a + b != arr[i + 1]) {
                System.out.println("B");
                return;
            }
        }

        System.out.println(arr[N-1] * a +b);
    }
}