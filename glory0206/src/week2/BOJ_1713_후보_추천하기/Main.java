package week2.BOJ_1713_후보_추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int totalRecommendation = Integer.parseInt(br.readLine());

        // 넣은 순서가 필요하기 때문에 LinkedHashMap 사용
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<totalRecommendation; i++){
            int num = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)){ // num이 map에 포함되어 있는 경우
                map.put(num, map.get(num)+1);
            } else if(map.size() < N){ // 아직 틀이 남아있는 경우
                map.put(num, 1);
            } else{ // 틀이 꽉 차있는 경우
                int minKey = -1;
                int minValue = 101;
                for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                    // value의 값이 최소인 key를 찾는다
                    if(entry.getValue() < minValue){
                        minValue = entry.getValue();
                        minKey = entry.getKey();
                    }
                }
                // 찾은 키를 삭제 후 새로운 학생을 넣는다
                map.remove(minKey);
                map.put(num, 1);
            }
        }
        List<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result);

        for(int student: result){
            System.out.print(student + " ");
        }
    }
}
