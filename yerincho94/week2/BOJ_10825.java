package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
    국어 점수가 감소하는 순서로
    국어 점수가 같으면 영어 점수가 증가하는 순서로
    국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
    모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
    (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
*/

// 국영수
public class BOJ_10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students.add(
                new Student( // 한꺼번에 담아야해서 객체 생성
                        st.nextToken(), // 이름
                        Integer.parseInt(st.nextToken()), // 국어
                        Integer.parseInt(st.nextToken()), // 영어
                        Integer.parseInt(st.nextToken())) // 수학
            );
        }
        /*students.sort((a, b) -> {
            if (a.kor != b.kor) return Integer.compare(b.kor, a.kor);
            if (a.eng != b.eng) return Integer.compare(a.eng, b.eng);
            if (a.math != b.math) return Integer.compare(b.math, a.math);
            return a.name.compareTo(b.name);
        });*/
        students.sort(Comparator
                .comparingInt((Student s) -> s.kor).reversed() // 기본 오름차순임으로 reverse()
                .thenComparingInt(s -> s.eng)
                .thenComparing(Comparator.comparingInt((Student s) -> s.math).reversed()) // 그냥 위처럼 reverse해버리면 전체 체인에 영향이감
                .thenComparing(s -> s.name)
        );

        for (Student s : students){
            System.out.println(s.name);
        }
    }

    static class Student {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }
}

