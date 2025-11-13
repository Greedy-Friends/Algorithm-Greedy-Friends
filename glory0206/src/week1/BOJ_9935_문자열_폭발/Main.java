package week1.BOJ_9935_문자열_폭발;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String str = sc.nextLine();
        String boom = sc.nextLine();
        int boomLen = boom.length();

        // Deque에 문자별로 넣기
        for(char c : str.toCharArray()) {
            stack.push(c);

            if(c == boom.charAt(boomLen-1) && stack.size() >= boomLen) {
                boolean like = true;

                for(int i = 0; i < boomLen; i++) {
                    if(stack.get(stack.size() - boomLen + i) != boom.charAt(i)) {
                        like = false;
                        break;
                    }
                }

                if(like) {
                    for(int i=0; i<boomLen; i++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
