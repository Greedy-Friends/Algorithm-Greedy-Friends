// [BOJ] 12789: 도키도키 간식드리미
package somyoung.week1;

import java.util.*;
import java.io.*;

public class BOJ_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>(); // 줄 서있는 곳
        Stack<Integer> stack = new Stack<>(); // 설 수 있는 공간

        StringTokenizer st = new StringTokenizer(br.readLine());
        int order = 1; // 번호표 순서

        for(int i=0; i<n; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        while(!queue.isEmpty()){
            // 큐의 맨 앞과 순서가 일치할 경우
            if(queue.peek() == order){
                queue.poll();
                order++;
            }
            // 스택의 peek와 순서가 일치할 경우
            else if(!stack.isEmpty() && stack.peek() == order){
                stack.pop();
                order++;
            }
            // 모두 아닐 경우
            else {
                stack.push(queue.poll());
            }
        }

        // 스택 안의 남은 번호 순서 확인
        while(!stack.isEmpty()){
            int current = stack.pop();
            if(current == order){
                order++;
            } else {
                System.out.print("Sad");
                return;
            }
        }

        System.out.print("Nice");
    }
}
