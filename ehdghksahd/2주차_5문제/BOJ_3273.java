import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/3273

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[N];
        int target = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
            set.add(number[i]);
        }

        for(int n : number) {
            int tmp = target - n; // number안에 target-n이 있으면 같은 쌍
            if(n != tmp) {
                if(set.contains(tmp)) {
                    answer++;
                    set.remove(n); // 중복처리
                }
            }
        }
        System.out.println(answer);
    }
}
