package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    1. 종이는 서로 이웃한 문자 사이에서만 접을 수 있다.
    2. 서로 맞닿은 문자 쌍 중에서, 서로 같은 문자라면 점수가 된다.
    목표 : 종이를 한 번 접어서 얻을 수 있는 "최대의 점수"는?

    아이디어:
     1. 수기로 적어봤을땐, 주어진 문자열을 반으로 가르면 답이 나오던디..
        - 반으로 접으면 안됨.. 그러면 비교를 할 수 없는 애들이 나옴 하나하나씩 비교해야함.
     2. ABBAB ->
        [A, B] [B, A, B] -> [B, A, B]를 뒤집어야해 .reverse() 가능?
         0  1                0  1  2 -> 아씨 얘는 어떻게 비교를 해야하지..?
        일단 이건 뒤집어도 똑같으니까
        BAAC ->
        [B, A][A, C] -> [C, A]
        0   1            0   1
        if ?(i) == ?(i) -> count++; 이런식으로...
     3. right.reverse()으로 했을때 -> 예제입력1은 잘 나오는데, 예제입력2는 틀린걸로 나옴.
        - 수기한걸 다시 보니 굳이 right.reverse()말고 left.reverse()하면 그냥 정답임..
        - 생각의 변화를 계속 해보자!!
 */

// 문자열 접기 (실버4)
public class BOJ_31846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 문자열들의 길이
        String S = br.readLine(); // 문자열들
        int Q = Integer.parseInt(br.readLine()); // Q개의 답해야한다

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            String str = S.substring(l-1, r); // l~r 범위 문자열 추출
            int maxCount = 0; // 최대 점수

            for (int j = 0; j < str.length(); j++) {
                String left = str.substring(0, j + 1); // A
                String right = str.substring(j + 1); // BAA
                String reversedLeft = new StringBuilder(left).reverse().toString(); // 뒤집어 (AAB)

                int count = 0; // 점수
                // 무조건 left기준으로 비교하면 안됨, left, right 둘 중 짧은 쪽의 길이만큼 비교
                int minLength = Math.min(reversedLeft.length(), right.length());

                for (int k = 0; k < minLength; k++) {
                    if(reversedLeft.charAt(k) == right.charAt(k)) count++; // 모든 경우의 수 다 카운트
                }
                maxCount = Math.max(maxCount, count); // 최대값 갱신
            }
            System.out.println(maxCount);

        }
    }
}
