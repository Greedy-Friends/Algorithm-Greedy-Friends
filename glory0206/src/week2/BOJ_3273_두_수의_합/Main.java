package week2.BOJ_3273_두_수의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(br.readLine());
        
        // 수열 배열 생성
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 수열 배열 오름차순 정렬
        Arrays.sort(nums);
        
        int left = 0;
        int right = n-1;
        int count = 0;

        while(left<right){
            int sum = nums[left] + nums[right];
            if(sum == x){
                count++;
                left++;
                right--;
            } else if(sum < x){
                left++;
            } else{
                right--;
            }
        }
        System.out.println(count);
    }
}
