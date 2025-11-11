//  [BOJ] 10825: 국영수
package somyoung.week2;

import java.util.*;
import java.io.*;

public class BOJ_10825 {
    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> scores = new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scores.add(new Student(name, kor, eng, math));
        }

        // 1. compare 메서드를 직접 오버라이딩
        scores.sort(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.kor != o2.kor) return o2.kor - o1.kor; // 국어 내림차순
                if(o1.eng != o2.eng) return o1.eng - o2.eng; // 영어 오름차순
                if(o1.math != o2.math) return o2.math - o1.math; // 수학 내림차순
                return o1.name.compareTo(o2.name); // 이름 오름차순
            }
        });

        // // 2. 람다 Comparator 체이닝
        // scores.sort(
        //   Comparator.comparingInt((Student s) -> s.kor).reversed() // 국어 내림차순
        //     .thenComparingInt(s->s.eng) // 영어 오름차순
        //     .thenComparing(Comparator.comparingInt((Student s)->s.math).reversed()) // 수학 내림차순
        //     .thenComparing(s->s.name) // 이름 오름차순
        // );
        // 체이닝된 Comparator에서 reversed()를 호출하면, 지금까지 누적된 모든 정렬 기준의 순서 반전
        // 특정 키만 반전하고 싶으면 안쪽에 감싸줘야 함
        // ex) .thenComparing(Comparator.comparingInt((Student s)->s.math).reversed())
        // 정렬 조건이 많으면 직접 오버라이딩이 안전


        StringBuilder sb = new StringBuilder();

        for(Student s : scores){
            sb.append(s.name).append('\n');
        }

        System.out.print(sb);
    }
}
