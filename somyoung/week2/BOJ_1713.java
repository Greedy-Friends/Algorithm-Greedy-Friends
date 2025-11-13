// [BOJ] 1713: 후보 추천하기
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new LinkedHashMap<>();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int key = Integer.parseInt(st.nextToken());

            // 비어있는 사진틀X, 새롭게 추천받은 학생
            if(map.size() >= n && !map.containsKey(key)){

                int minValue = Collections.min(map.values());

                for(int oldKey : map.keySet()){ // 삽입된 순서대로 탐색
                    if(map.get(oldKey) == minValue){
                        map.remove(oldKey);
                        break;
                    }
                }
            }

            // map 추천수 증가
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // key 기준 오름차순 정렬
        Map<Integer, Integer> treeMap = new TreeMap<>(map);
        for(int key: treeMap.keySet()){
            System.out.print(key + " ");
        }
    }
}
