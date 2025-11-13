package week1.BOJ_9012_괄호;

import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++){
            Stack<Character> stack = new Stack<>();

            String arr = sc.nextLine();
            boolean answer = true;

            for(char c : arr.toCharArray()){
                if(c == '(') {
                    stack.push(c);
                } else if(c == ')'){
                    if(stack.isEmpty()){
                        answer = false;
                        break;
                    } else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()){
                answer = false;
            }
            System.out.println(answer ? "YES" : "NO");
        }
    }
}
