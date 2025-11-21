// [BOJ] 9012: 괄호
package somyoung.week1;

import java.util.*;
import java.io.*;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            Stack<Character> stack = new Stack<>();
            boolean finish = false;

            String PS = br.readLine();

            for(int j=0; j<PS.length(); j++){
                char P = PS.charAt(j);

                if(P == '('){
                    stack.push(P);
                }

                if(P == ')'){
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else { // 스택이 비었을 경우
                        System.out.println("NO");
                        finish = true;
                        break;
                    }
                }
            }

            if(finish){
                continue; // 판별이 끝났을 경우, 다음 루프로 이동
            }

            if(stack.isEmpty()){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

