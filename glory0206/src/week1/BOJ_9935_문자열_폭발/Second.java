package week1.BOJ_9935_문자열_폭발;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String boom = sc.nextLine();
        String result = "";

        while(true){
            result = str.replaceAll(boom, "");
            if (str.equals(result)){
                break;
            } else{
                str = result;
            }
        }
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }
}
