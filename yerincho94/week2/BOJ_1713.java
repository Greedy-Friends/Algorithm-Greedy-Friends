package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    원래 Deque를 사용해서 데이터를 순서대로 큐처럼 넣고, 오래된 건 빼자로 생각했었는데..
    이러면 로직이 더 복잡해지고, '추천 수'를 관리할 수 없음.
    Map + List를 사용해서
        Map<Integer,Integer> → 학생 번호별 추천수
        List<Integer> → 사진틀 순서 (오래된 순)
*/

// 후보 추천하기
public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int frame = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine()); // 추천 총 횟수
        String[] students = br.readLine().split(" ");

        Map<Integer, Integer> recCntByNum = new HashMap<>(); //학생 번호별 추천수 담을 예정
        List<Integer> frameList = new ArrayList<>(); // 사진틀

        for (int i = 0; i < N; i++) {
            int student = Integer.parseInt(students[i]); // 학생 번호

            if(recCntByNum.containsKey(student)){ // 이미 틀에 있으면 count +1
                recCntByNum.put(student, recCntByNum.get(student) + 1);
                continue; // 다음 추천으로 스킵
            }

            if(frameList.size() < frame) { // frame보다 크기가 작으면 새학생 추가
                frameList.add(student);
                recCntByNum.put(student, 1);
                continue;
            }

            // 틀이 꽉차있을때느..
            // 제일 오래됐다는건 제일 첫번째 값 아님? 근데 추천 수가 적은 학생은..?
            int removeTarget = frameList.get(0); // 제거할 대상 : 맨 앞 학생
            int minCount = recCntByNum.get(removeTarget); // 그 학생의 추천수로 기준

            // 추천 수가 적은 학생
            for (int f : frameList) {
                int recCnt = recCntByNum.get(f); // map의 f값
                if(recCnt < minCount) {
                    minCount = recCnt;
                    removeTarget = f; // 더 적은 학생으로 교체
                }
            }
            // 이제 제거
            frameList.remove(Integer.valueOf(removeTarget)); // int -> Integer로
            recCntByNum.remove(removeTarget);

            // 제거했으니 다시 넣어
            frameList.add(student);
            recCntByNum.put(student, 1);
        }
        Collections.sort(frameList); // 오름차순 정렬
        for (int s : frameList) System.out.print(s + " ");
    }
}
