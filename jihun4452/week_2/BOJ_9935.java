import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		/**
		 * 상근이는 문자열에 폭발 문자열을 심음,, 왜?
		 * 문자열이 폭발하면 그 문자는 문자열에서 사라짐, 그리고 남은 문자열은 합쳐진다.
		 * 문자열이 폭발 문자열을 포함 할 경우 모든 폭문이 폭발함, 남은 문자열을 붙여 새로운것을 창조함
		 * 새로 생긴것에 폭발 문자열이 포함될 수 있음,
		 * 폭발 문자열이 없을때까지 된다.
		 * 문자가 남아있지 않은경우 FRULA를 표시한다. 폭문은 중복 X
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> stack = new Stack<Character>();

		String sacrifice = br.readLine(); // 희생당할 문자
		String bomb = br.readLine(); //폭탄

		for (char c : sacrifice.toCharArray()) {
			stack.push(c); // 값들 넣어주고,

			if (stack.size() >= bomb.length()) { //작으면 검사할 필요없음, 아님 그런데,, 붙여진다면? 아니지 사이즈 작은께
				boolean boom = true;  //맞으면 폭발
				for (int i = 0; i < bomb.length(); i++) {
					//폭탄의 길이만큼 돌고 겟? 터지지않음일단 만들고
					if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) { //겟을 하는데 bomb의 char와 같지않다면 터뜨리지 않는다.
						//하나라도 맞지않으면 안터트린다. 12ab이고 bomb가 cb라면 일단 4 - 2 + 0, 2인데, stack.get(2) != bomb charAt(0)
						boom = false; //안같으면 안터짐 애초에 이게 맞나?
						break;
					}
				}
				if (boom) { //같으면 Pop?? 근데 Pop하면 한개만 나오는거 아닌가,,
					for (int i = 0; i < bomb.length(); i++) {
						stack.pop();
					}
				}
			}
		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (char ch : stack) {
				sb.append(ch);
			}
			System.out.println(sb.toString());
		}
	}
}
