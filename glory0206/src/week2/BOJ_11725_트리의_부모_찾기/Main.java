package week2.BOJ_11725_트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i=0; i<=N; i++){
            tree.add(new ArrayList<>());
        }

        for (int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 양방향 연결
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int[] parent = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Stack<Integer> stack = new Stack<>(); // dfs 사용 시 stack
        stack.push(1); // root node는 1

        while(!stack.isEmpty()){
            int node = stack.pop();

            for (int nextNode: tree.get(node)){
                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    parent[nextNode] = node; // nextNode의 부모는 node
                    stack.push(nextNode);
                }
            }
        }
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
}
