package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
    문제: 각 책들의 원래 위치가 주어질 때, 책을 모두 제자리에 놔둘 때 드는 '최소 걸음 수'.
    둘째 줄 : 책들이 원래 있어야할 자리

    아이디어:
     1. 0에서 책 M개 들기
     2. 해당 위치들에 가서 책 꽂기
     3. 0으로 돌아오기 (다음 책 들러) <---이게 핵심
     4. 반복..
     5. 중간 지점들은 지나가는 길에 있음.
        ex) 0에서 -39까지 가는 길에 -6,-28,-29,-37이 있음
        어떤 순서로 가든 = 가장 먼 거리 * 2
     6. 음수에서 양수로 가는것 보다는, 음수는 음수끼리, 양수는 양수끼리 비교하는게 효율적임.
 */

// 도서관 (골드4)
public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 책의 개수
        int M = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책의 개수

        String[] bookLocation = br.readLine().split(" "); // 책들이 원래 있어야할 자리

        ArrayList<Integer> negativeNums = new ArrayList<>();
        ArrayList<Integer> positiveNums = new ArrayList<>();

        // 먼저 음수, 양수대로 분리 작업
        for (int i = 0; i < N; i++) {
            if(Integer.parseInt(bookLocation[i]) < 0) {
                negativeNums.add(Math.abs(Integer.parseInt(bookLocation[i]))); // 음수를 절대값
            } else {
                positiveNums.add(Integer.parseInt(bookLocation[i]));
            }
        }
        // 내림차순으로 정렬
        negativeNums.sort(Collections.reverseOrder());
        positiveNums.sort(Collections.reverseOrder());

        // M개씩 묶어서 거리 계산
        int totalDistance = getTotalDistance(negativeNums, M, positiveNums);

        System.out.println(totalDistance);
    }

    private static int getTotalDistance(ArrayList<Integer> negativeNums, int M, ArrayList<Integer> positiveNums) {
        ArrayList<Integer> distances = new ArrayList<>();
        for (int i = 0; i < negativeNums.size(); i += M) {
            distances.add(negativeNums.get(i));
        }
        for (int i = 0; i < positiveNums.size(); i += M) {
            distances.add(positiveNums.get(i));
        }

        // 가장 먼 거리 찾기
        int maxDistance = Collections.max(distances);

        // 총 거리 계산하기
        int totalDistance = 0;
        for (int dist : distances) {
            totalDistance += dist * 2; // 왕복으로
        }
        totalDistance -= maxDistance; // 마지막은 편도로 계산
        return totalDistance;
    }
}
