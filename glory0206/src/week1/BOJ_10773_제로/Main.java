package week1.BOJ_10773_제로;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();

        for(int i=0; i<K; i++){
            int num = sc.nextInt();
            if(num != 0){
                stack.push(num);
            }else{
                stack.pop();
            }
        }
        int result = stack.stream().reduce(0, (a, b) -> a+b);
        System.out.println(result);
    }
}
