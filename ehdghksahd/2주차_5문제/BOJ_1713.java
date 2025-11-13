import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/1713

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int R = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); // 넣은 순서를 지키는 map
        for(int i = 0; i < R; i ++) {
            int target = Integer.parseInt(st.nextToken());
            if(map.containsKey(target)) map.merge(target, 1, Integer::sum); // 없으면 target,1 초기화 있으면 추천수++
            else {
                if(map.size() < N) map.put(target, 1);

                else {
                    int min = Integer.MAX_VALUE; // 최소값
                    for(int n : map.values()) {
                        min = Math.min(min, n);
                    }

                    Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
                    while(iter.hasNext()) {
                        Map.Entry<Integer, Integer> tmp = iter.next();

                        if(tmp.getValue() == min) {
                            iter.remove();
                            break;
                        }
                    }
                    map.put(target, 1);
                }
            }
        }
        List<Integer> answer = new ArrayList<>(map.keySet());
        Collections.sort(answer);
        for(int k : answer) System.out.print(k + " ");

    }
}
