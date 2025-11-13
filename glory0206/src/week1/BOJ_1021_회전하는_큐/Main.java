package week1.BOJ_1021_회전하는_큐;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // Deque에 N의 수만큼 index 요소 추가
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            deque.offer(i);
        }

        int count = 0;

        for(int i=0; i<M; i++){
            int targetIndex = sc.nextInt();

            int left = 0;
            for(int index: deque){
                if(index == targetIndex){
                    break;
                }
                left++;
            }
            int right = deque.size() - left;

            // 왼 -> 오 회전
            if(left <= right){
                for(int j=0; j<left; j++){
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            // 오 -> 왼 회전
            else{
                for(int j=0; j<right; j++){
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }
            // 맨 앞의 요소 제거(일치하는 index)
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
