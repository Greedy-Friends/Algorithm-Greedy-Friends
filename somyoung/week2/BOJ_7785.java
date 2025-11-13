// [BOJ] 7785: 회사에 있는 사람
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String history = st.nextToken();

            map.put(name, history);
        }

        for(String name : map.keySet()){
            if(map.get(name).equals("enter")){
                list.add(name);
            }
        }

        list.sort(Collections.reverseOrder());

        for(String name: list){
            System.out.println(name);
        }
    }
}

