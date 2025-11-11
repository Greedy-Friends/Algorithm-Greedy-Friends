package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> input = new ArrayList<>();
            input.add(Integer.parseInt(st.nextToken()));
            input.add(Integer.parseInt(st.nextToken()));
            list.add(input);
        }

        // 끝나는 시간 오름차순 정렬, 같으면 시작 시간 오름차순 정렬
        list.sort((o1, o2) -> {
            if(o1.get(1).equals(o2.get(1))) return o1.get(0) - o2.get(0);
            else return o1.get(1) - o2.get(1);
        });

        int endTime = 0;
        int cnt = 0;

        for(int i=0; i<n; i++){
            int start = list.get(i).get(0);
            int end = list.get(i).get(1);

            if(start >= endTime){
                cnt++;
                endTime = end;
            }
        }

        System.out.print(cnt);
    }
}
