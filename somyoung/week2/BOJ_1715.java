// [BOJ] 1715: 카드 정렬하기
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            queue.offer(Integer.parseInt(br.readLine())); // 카드 묶음 오름차순 정렬
        }

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            int temp = a + b;
            sum += temp;
            queue.offer(temp); // 합친 카드 묶음 add
        }

        System.out.print(sum);
    }
}
