package week2.BOJ_1715_카드_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        List<Integer> list = new ArrayList<>();

        // 가장 작은 숫자 2개씩 더해가야 한다.
        while(pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            int sum = a+b;
            list.add(sum);
            pq.add(sum);
        }
        int answer = list.stream().reduce(0, (x, y) -> x+y);
        System.out.println(answer);
    }
}
