// [BOJ] 11725: 트리의 부모 찾기
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_11725 {
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1]; // 1-index-base
        parent = new int[n+1];

        for(int i=0; i<n+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 양방향 연결
            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(1); // 루트 노드부터 탐색

        for(int i=2; i<n+1; i++){
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int node){
        visited[node] = true;

        for(int next : list.get(node)){
            if(!visited[next]){
                dfs(next);
                parent[next] = node; // 부모 노드 마킹
            }
        }
    }
}
