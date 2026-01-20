import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2195

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int cnt = 0;
        int max = 0;
        for(int i = 0; i < P.length(); i += max) {
            max = 0;
            for(int j = i + 1; j <= P.length(); j++) {
                if(S.contains(P.substring(i, j))) max = j - i;  // S와 일치하는 것 중에 가장 긴 것 찾기

                else break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
