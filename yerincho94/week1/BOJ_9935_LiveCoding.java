package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 문자열 폭팔
public class BOJ_9935_LiveCoding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 첫번째 라인
        String bomb = br.readLine(); // 두번째 라인

        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()) { // 한 글자씩 비교해야함.
            stack.push(ch);
            //System.out.println(stack);
            if(stack.size() >= bomb.length()) {
                boolean flag = true;

                for (int i = 0; i < bomb.length(); i++) {
                    // System.out.println(i + ": " + stack + " "+ stack.size() + "\n" + "bomb: " + bomb + " " + bomb.length());
                    // 스택의 끝에서 bomb 길이만큼 떨어진 구간부터 검사
                    if(stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                        flag = false; // 하나라도 다르면 폭탄 아님
                        break;
                    }
                }

                if(flag) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.pop(); // 제거
                    }
                }
            }
        }

        // stack으로 넣은 문자들 StringBuilder로 담기
        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);

        System.out.println(sb.length() == 0  ? "FRULA" : sb);
    }
}
