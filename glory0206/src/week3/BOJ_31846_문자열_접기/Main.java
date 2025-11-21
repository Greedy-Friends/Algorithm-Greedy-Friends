package week3.BOJ_31846_문자열_접기;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String cutStr = "";

        for(int k=0; k<Q; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            cutStr = str.substring(l-1, r); // 확인해야 할 문자열
            int cutLen = cutStr.length();
            int maxSame = 0;

            for(int i=1; i<cutLen; i++){
                String leftPart = cutStr.substring(0, i); // 주어진 인덱스를 기준으로 좌측 문자열
                String rightPart = cutStr.substring(i); // 주어진 인덱스를 기준으로 우측 문자열

                // 좌측 문자열 뒤집기
                String reversedLeftPart = new StringBuilder(leftPart).reverse().toString();

                int minLen = Math.min(leftPart.length(), rightPart.length());
                int count = 0;

                // 비교하여 문자가 같을 경우 count + 1
                for(int j=0; j< minLen; j++){
                    if(reversedLeftPart.charAt(j) == rightPart.charAt(j)){
                        count++;
                    }
                }
                // 반복하며 가장 큰 count를 넣기 위한 변수
                maxSame = Math.max(maxSame, count);
            }
            sb.append(maxSame).append('\n');
        }
        System.out.print(sb.toString());
    }
}
