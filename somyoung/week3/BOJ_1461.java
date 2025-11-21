// [BOJ] 1461: 도서관
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 우선순위 큐 이용
        // 0에서 먼 x좌표 -> 가까운 x좌표 순으로 정렬
        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        }); // 양수 큐 내림차순
        PriorityQueue<Integer> negative = new PriorityQueue<>(); // 음수 큐 오름차순

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int location = Integer.parseInt(st.nextToken());
            if(location >= 0) positive.add(location);
            else negative.add(location);
        }

        int step = 0;
        int maxAbs = 0;

        // 책을 모두 제자리에 놔둔 후에는 다시 0으로 돌아올 필요는 없음
        // 모든 왕복 걸음수에 가장 먼 좌표의 절대값을 빼줘서 편도로 처리
        if(!positive.isEmpty() && !negative.isEmpty()){
            maxAbs = Math.max(positive.peek(), Math.abs(negative.peek()));
        } else if(positive.isEmpty()){
            maxAbs = Math.abs(negative.peek());
        } else if(negative.isEmpty()){
            maxAbs = positive.peek();
        }

        // 양수 큐 처리
        while(!positive.isEmpty()){
            for(int i=0; i<m; i++){
                int peek = positive.poll();
                if(i == 0) step += (peek * 2); // 첫번째 인덱스 좌표(더 먼 거리) 왕복 걸음 수 누적
                if(positive.isEmpty()) break; // 남은 좌표수가 m보다 작을 수 있으므로, 큐 비어있는지 확인 후 break
            }
        }

        // 음수 큐 처리
        while(!negative.isEmpty()){
            for(int i=0; i<m; i++){
                int peek = negative.poll();
                if(i == 0) step += (Math.abs(peek) * 2); // 음수이므로 절대값 누적
                if(negative.isEmpty()) break;
            }
        }

        System.out.print(step - maxAbs);
    }
}