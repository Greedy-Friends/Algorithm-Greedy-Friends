import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/10825

public class Main{
    private static class Student {
        private final String name; // 이름
        private final int k; // 국어점수
        private final int e; // 영어점수
        private final int m; // 수학점수

        Student(String name, int k, int e, int m){
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Student> sList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sList.add(new Student(st.nextToken() // 이름
                    , Integer.parseInt(st.nextToken()) // 국어점수
                    , Integer.parseInt(st.nextToken()) // 영어점수
                    , Integer.parseInt(st.nextToken()))); // 수학점수
        }

        sList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if(a.k == b.k) {
                    if(a.e == b.e) {
                        if(a.m == b.m) return a.name.compareTo(b.name); // 이름 사전 순
                        return b.m - a.m; // 수학 점수 내림차순
                    }
                    return a.e - b.e; // 영어 점수 오름차순
                }
                return b.k - a.k; // 국어 점수 내림차순
            }
        });
        for(Student student : sList) System.out.println(student.name);
    }
} // 이렇게 짜는게 맞나...
