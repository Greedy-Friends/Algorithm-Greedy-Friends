package week1.BOJ_12789_도키도키_간식드리미;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            queue.offer(sc.nextInt());
        }
        int checktNum = 1;

        while(!queue.isEmpty()){
            int num = queue.poll();
            if(num == checktNum){
                checktNum++;
            } else{
                stack.push(num);
            }

            while(!stack.isEmpty() && stack.peek() == checktNum){
                stack.pop();
                checktNum++;
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
