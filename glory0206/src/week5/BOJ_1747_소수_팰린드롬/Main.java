package week5.BOJ_1747_소수_팰린드롬;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(true){
            boolean prime = isPrime(N);
            boolean palindrome = isPalindrome(N);

            if(prime == true && palindrome == true){
                System.out.println(N);
                break;
            }
            N++;
        }
    }

    public static boolean isPalindrome(int n){
        String str = Integer.toString(n);

        // 2 포인터 사용
        int left = 0;
        int right = str.length()-1;

        while(left<right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n){
        if(n <= 1){ // 0과 1은 소수가 아니다
            return false;
        }
        if(n == 2){ // 2는 소수
            return true;
        }
        if(n % 2 == 0){ // 짝수는 소수가 아니다
            return false;
        }

        // 홀수들에 대해 판단
        for (int i=3; i*i <= n; i+=2) { // i<n을 조건으로 사용 시 시간 초과
            if (n % i == 0){
                return false; // 자신 또는 1 외에 나눠지면 소수가 아니다
            }
        }
        return true; // 위의 조건들에 해당하지 않는다면, 소수이다.
    }
}

