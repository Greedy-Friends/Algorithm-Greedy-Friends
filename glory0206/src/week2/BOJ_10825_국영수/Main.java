package week2.BOJ_10825_국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[][] students = new String[N][4];

        for (int i=0; i<N; i++){
            students[i] = br.readLine().split(" ");
        }

        Arrays.sort(students, (a, b) -> {
            int kor1 = Integer.parseInt(a[1]);
            int kor2 = Integer.parseInt(b[1]);
            int math1 = Integer.parseInt(a[3]);
            int math2 = Integer.parseInt(b[3]);
            int eng1 = Integer.parseInt(a[2]);
            int eng2 = Integer.parseInt(b[2]);

            if(kor1 != kor2){
                return kor2 - kor1;
            } else if(eng1 != eng2){
                return eng1 - eng2;
            } else if(math1 != math2){
                return math2 - math1;
            } else{
                return a[0].compareTo(b[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            sb.append(students[i][0]).append("\n");
        }
        System.out.println(sb);
    }
}
