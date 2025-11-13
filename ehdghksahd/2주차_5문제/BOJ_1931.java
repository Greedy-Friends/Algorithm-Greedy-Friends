import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1931

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> r = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            r.add(new ArrayList<>());
            r.get(i).add(s);
            r.get(i).add(e);
        }

        r.sort((list1, list2) -> {
            int s1 = list1.get(0);
            int s2 = list2.get(0);
            int e1 = list1.get(1);
            int e2 = list2.get(1);

            if(e1 != e2) return e1 - e2;
            return s1 - s2;
        });

        int tmp = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(r.get(i).get(0) >= tmp) {
                tmp = r.get(i).get(1);
                cnt++;
            }
        }

        System.out.println(r);
    }
}
