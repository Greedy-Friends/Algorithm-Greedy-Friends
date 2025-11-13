package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1931_LiveCoding {
    static class Meeting {
        int startTime;
        int endTime;

        public Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(
                    Integer.parseInt(st.nextToken()), // startTime
                    Integer.parseInt(st.nextToken()) // endTime
            ));
        }

        // 정렬시작 -> 결론적으로 회의의 끝시간 오름차순으로 정렬
        // 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
        meetings.sort((a, b) -> {
            if (a.endTime == b.endTime) {
                return a.startTime - b.startTime;
            }
            return a.endTime - b.endTime; // 회의끝시간
        });

        // 이전 회의 끝나는 시간이 <= 회의 시작 시간 그래야 회의 가능
        int count = 0; // 가능 회의실 갯수
        int lastEndTime = 0; // 마지막으로 회의가 끝나는 시간 그래야 다음 회의와 비교가능
        for (Meeting meeting : meetings) {
            if(meeting.startTime >= lastEndTime) {
                count++;
                lastEndTime = meeting.endTime;
            }
        }
        System.out.println(count);
    }
}
