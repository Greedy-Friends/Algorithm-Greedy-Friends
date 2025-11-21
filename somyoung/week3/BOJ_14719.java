// [BOJ] 14719: 빗물
package somyoung.week3;

import java.io.*;
import java.util.*;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽 -> 오른쪽 스캔, 0 ~ left
        // 처음 시작한 높이보다 크거나 같은 경우 그룹 확정
        int result = 0;
        int left = 0; // 현재 그룹의 기준 col
        int leftHeight = height[left]; // 현재 그룹의 왼쪽 벽 높이

        for(int col=1; col<w; col++){
            if(height[col] >= leftHeight){

                // left ~ col-1 까지 한 그룹으로 묶고, 빗물 계산
                for(int i=left+1; i<col; i++){
                    result += (leftHeight - height[i]);
                }

                // col을 새로운 왼쪽 벽으로 갱신
                left = col;
                leftHeight = height[col];
            }
        }

        // 오른쪽 -> 왼쪽 스캔, left 이후
        int right = w-1;
        int rightHeight = height[right];

        for(int col=w-2; col>=left; col--){
            if(height[col] >= rightHeight){

                // col+1 ~ right 까지 한 그룹으로 묶고, 빗물 계산
                for(int i=col+1; i<right; i++){
                    result += (rightHeight - height[i]);
                }

                // col을 새로운 오른쪽 벽으로 갱신
                right = col;
                rightHeight = height[col];
            }
        }

        System.out.println(result);
    }
}