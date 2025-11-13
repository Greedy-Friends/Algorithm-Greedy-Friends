import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1715

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i < N; i++) q.offer(Integer.parseInt(br.readLine()));

        while(q.size() != 1) {
            int pre = q.poll();
            int next = q.poll();
            sum += pre + next;
            q.offer(pre + next);
        }
        System.out.println(sum);
    }
}
