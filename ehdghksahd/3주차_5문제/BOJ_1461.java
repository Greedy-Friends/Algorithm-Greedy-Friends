import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1461

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 양수 // 내림 차순
        PriorityQueue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder()); // 음수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num < 0) nq.offer(num * -1);
            else pq.offer(num);
        }
        int max = 0;
        if(pq.isEmpty()) max = nq.peek();
        else if(nq.isEmpty()) max = pq.peek();
        else max = Math.max(pq.peek(), nq.peek());

        int cnt = 0; // 걸음 수
        while(!pq.isEmpty()) {
            cnt += pq.poll() * 2;

            for(int i = 0; i < M - 1 && !pq.isEmpty(); i++) pq.poll();
        }

        while(!nq.isEmpty()) {
            cnt += nq.poll() * 2;

            for(int i = 0; i < M - 1 && !nq.isEmpty(); i++) nq.poll();
        }

        cnt -= max;

        System.out.println(cnt);
    }
}
