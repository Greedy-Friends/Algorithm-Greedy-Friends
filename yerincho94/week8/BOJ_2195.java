package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열 S와 P가 주어짐
 * S에서 연속된 부분 문자열을 복사해서 P를 만들기
 * 최소 복사 횟수는?
 *
 * 규칙:
 * - S의 연속된 부분 문자열만 복사 가능
 * - 복사한 문자열을 P 뒤에 붙임
 * - P가 완성될 때까지 반복
 */
// 문자열 복사(골드5) - 그리디
public class BOJ_2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();  // 복사할 문자열
        String P = br.readLine();  // 만들 문자열

        int idx = 0;      // P의 현재 위치
        int count = 0;    // 복사 횟수

        // P를 다 만들 때까지
        while (idx < P.length()) {
            // S에서 가장 긴 매칭 찾기
            int maxLen = findLongestMatch(S, P, idx);
            idx += maxLen; // 매칭된 만큼 이동
            count++;
        }

        System.out.println(count);
    }

    static int findLongestMatch(String S, String P, int pIdx) {
        int maxLen = 0;

        // S의 각 위치에서 시도
        for (int i = 0; i < S.length(); i++) {
            int len = 0;

            // S[i]부터 P[pIdx]와 얼마나 매칭되는지
            while (i + len < S.length() &&
                    pIdx + len < P.length() &&
                    S.charAt(i + len) == P.charAt(pIdx + len)) {
                len++;
            }
            maxLen = Math.max(maxLen, len); // 최댓값 갱신
        }

        return maxLen;
    }
}
