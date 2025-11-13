// [BOJ] 3273: 두 수의 합
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        int res = 0;

        // 첫번째 시도 : 조합 이중 for문 사용 -> 시간 초과
        // for(int i=0; i<n; i++){
        //   for(int j=i+1; j<n; j++){
        //     if(arr[i] + arr[j] == x){
        //       res++;
        //     }
        //   }
        // }

        // 두번째 시도 : 정렬 + 투포인터
        Arrays.sort(arr); // 오름차순 정렬

        int start = 0;
        int end = n - 1;

        while(start < end){
            int sum = arr[start] + arr[end];

            if(sum == x){
                res++;
                start++;
                end--;
            } else if(sum > x){
                end--;
            } else { // sum < x
                start++;
            }
        }

        System.out.print(res);
    }
}