package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/*
    이중for문으로 작성하려고 했는데, 이중 루프 (O(N²))으로 인해서 백준에서는 시간초과임.
    HashSet으로 해당 숫자의 짝이 들어있는지 확인만 하면 해결되는 문제!
    Integer.parseInt(arr[i]) + Integer.parseInt(arr[j]) == x 니까
    결국 짝을 찾으려면 짝 = x - arr[i];
*/

// 두 수의 합
public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 9
        String[] arr = br.readLine().split(" "); // [5, 12, 7, 10, 9, 1, 2, 3, 11]
        int x = Integer.parseInt(br.readLine()); // 13

        HashSet<Integer> set = new HashSet<>(); // 중복된 짝이 이미 있으면 저장안함.
        int count = 0;

        for (int i = 0; i < N; i++) {
            int pair = x - Integer.parseInt(arr[i]);
            if(set.contains(pair)){
                count++; // 짝이 있다면 카운트
            } else {
                set.add(Integer.parseInt(arr[i]));
            }
        }
        System.out.println(count);
    }
}
