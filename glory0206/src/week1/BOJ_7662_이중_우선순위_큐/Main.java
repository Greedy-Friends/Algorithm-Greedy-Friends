package week1.BOJ_7662_이중_우선순위_큐;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            int k = sc.nextInt();

            for(int j=0; j<k; j++){
                char operate = sc.next().charAt(0);
                int num = sc.nextInt();

                if(operate == 'I'){
                    // Key의 값이 같을 경우, value의 값 1 증가
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }else if(operate == 'D'){
                    if(treeMap.isEmpty()){
                        continue;
                    }
                    if(num == 1){// 최댓값 삭제
                        int maxKey = treeMap.lastKey();
                        if(treeMap.get(maxKey) == 1){ // 해당 정수가 하나인 경우
                            treeMap.remove(maxKey);
                        } else{
                            // 해당 정수가 2개 이상일 경우
                            treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                        }
                    }
                    else if(num == -1){ // 최솟값 삭제
                        int minKey = treeMap.firstKey();
                        if(treeMap.get(minKey) == 1){ // 해당 정수가 하나인 경우
                            treeMap.remove(minKey);
                        } else{ // 해당 정수가 2개 이상일 경우
                            treeMap.put(minKey, treeMap.get(minKey) - 1);
                        }
                    }
                }
            }
            if (!treeMap.isEmpty()){
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            } else{
                System.out.println("EMPTY");
            }
        }
    }
}
