// [BOJ] 10773: 제로
package somyoung.week1;

import java.util.*;
import java.io.*;

public class BOJ_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num != 0){
                stack.push(num);
            } else { // 정수가 0일 경우
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        int result = 0;

        if(!stack.isEmpty()){
            for(int num :stack){
                result += num;
            }
        }

        System.out.print(result);
    }
}

