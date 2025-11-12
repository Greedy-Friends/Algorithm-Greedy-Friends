// [BOJ] 9935: 문자열 폭발
package somyoung.week1;

import java.util.*;
import java.io.*;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String target = br.readLine();

        Stack<Character> stack = new Stack<>();

        // 문자 한글자 씩 삽입하며, 새로 추가된 문자 더하여 조합 후 target과 일치하면 pop()
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));

            // 스택 문자열이 폭발 문자열 길이 이상일 때만 검사
            if(stack.size() >= target.length()){
                int cnt = 0;
                for(int j=0; j<target.length(); j++){
                    if(stack.get(stack.size() - target.length() + j) == target.charAt(j)){
                        cnt++;
                    } else {
                        break; // stack과 target 문자가 하나라도 다르면 break
                    }
                }

                if(cnt == target.length()){ // 완전히 일치하면 폭발
                    for(int j=0; j<target.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        if(stack.isEmpty()){
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.print(sb.toString());
        }
    }
}