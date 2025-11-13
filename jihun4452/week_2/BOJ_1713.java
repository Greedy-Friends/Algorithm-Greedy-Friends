import java.util.*;
import java.io.*;

public class Main {
	static class Student {
		int num;
		int count;
		int time;

		Student(int num, int count, int time) {
			this.num = num;
			this.count = count;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사진틀 수
		int total = Integer.parseInt(br.readLine()); // 전체 추천 횟수
		String[] input = br.readLine().split(" ");

		ArrayList<Student> list = new ArrayList<>();
		int time = 0;

		for (int i = 0; i < total; i++) {
			int num = Integer.parseInt(input[i]);
			time++;
			boolean found = false;

			// 이미 있는 학생이면 추천수 증가
			for (Student s : list) {
				if (s.num == num) {
					s.count++;
					found = true;
					break;
				}
			}

			if (found) continue;

			// 아직 틀이 비어있으면 그냥 추가
			if (list.size() < N) {
				list.add(new Student(num, 1, time));
			} else {
				// 삭제할 학생 찾기
				int removeIndex = 0;
				for (int j = 1; j < list.size(); j++) {
					Student now = list.get(j);
					Student min = list.get(removeIndex);

					if (now.count < min.count) removeIndex = j;
					else if (now.count == min.count && now.time < min.time) removeIndex = j;
				}
				list.remove(removeIndex);
				list.add(new Student(num, 1, time));
			}
		}

		// 번호 오름차순 정렬
		list.sort((a, b) -> a.num - b.num);

		for (Student s : list) {
			System.out.print(s.num + " ");
		}
	}
}
