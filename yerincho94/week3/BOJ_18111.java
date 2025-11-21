package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// for문을 너무 많이써서 제출이 될까 걱정했는데, 제출이 되어서 조금 놀랬다.

// 마인크래프트 (실버2)
public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤에 들어있는 블록수

        int[][] landSize = new int[N][M]; // 땅의 크기 일단 2중배열에 넣어
        for(int i = 0; i < N; i++) {
            StringTokenizer step = new StringTokenizer(br.readLine());
            for(int j = 0; j< M; j++) {
                landSize[i][j] = Integer.parseInt(step.nextToken());
            }
        }

        /*
          목표:
            1. 땅을 고르는 데 걸리는 시간
            2. 땅의 높이(Height) <= 256
            -> if 걸리는 시간이 같다면 땅의 높이가 높은걸로
            블록제거 + 인벤넣기 -> 2초
            인벤 + 블록놓기 -> 1초
        */
        int minTime = Integer.MAX_VALUE; // 최소시간 저장용
        int resultHeight = 0; // 결과 높이 저장용

        for (int targetHeight = 0; targetHeight <= 256; targetHeight++) {
            int time = 0;
            int currInventory = B; // 초기인벤

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int currentHeight = landSize[i][j]; // 현재 칸의 높이
                    int diff = currentHeight - targetHeight; // 현재 칸의 높이와 목표높이 차이 계산

                    if(diff > 0) { // 현재 높이가 더 높으면 -> 블록제거 (2초) / 인벤도 정리
                        time += diff * 2; // 차이높이 만큼 * 2초
                        currInventory += diff; // 인벤 증가
                    } else if (diff < 0) { // 현재 높이가 더 낮으면 -> 블록추가 (1초)
                        // 근데 음수로 되버리는데..? -> 절대값으로 해결
                        time += Math.abs(diff) * 1; // 차이높이 만큼 * 1초
                        currInventory -= Math.abs(diff); // 인벤 감소
                    }
                }
            }

            // 인벤토리 정리 및 최종 결과
            if(currInventory >= 0 && time <= minTime) {
                minTime = time;
                resultHeight = targetHeight;
            }
        }

        System.out.println(minTime + " " + resultHeight);

    }
}
