import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11725

public class Main{
    static List<List<Integer>> tree ;
    static int[] parent;
    static boolean visited[];

    public static void dfs(int node) {
        visited[node] = true; // 노드 방문 여부

        for(int n : tree.get(node)) {
            if(!visited[n]) { // 방문한적 없고, 연결된 노그가 있으면
                parent[n] = node; // 현재 노드가 next의 노드
                dfs(n);
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) tree.add(new ArrayList<>());
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            tree.get(first).add(second);
            tree.get(second).add(first);

            // 트리 연결 끝
        }

        // 트리 순회하기
        dfs(1);

        for(int i = 2; i <= N; i++) System.out.println(parent[i]);

    }
}
