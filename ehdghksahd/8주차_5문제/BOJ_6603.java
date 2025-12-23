import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/6603

public class Main{
    public static void combi(int[] numbers, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            for(int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }


        for(int i = start; i < n; i++) {
            visited[i] = true;
            combi(numbers, visited, i + 1, n, r - 1);
            visited[i] = false; // 백트래킹
        }

    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            int[] numbers = new int[N];
            boolean[] visited = new boolean[N];


            for(int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            combi(numbers, visited, 0, N, 6); // 숫자들, 방문여부, 시작위치, 총 길이, 고르는 수
            System.out.println();

        }
    }
}
