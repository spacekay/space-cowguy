import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String front = "";
		char[] back;
		int l;
		boolean run = true;

		while (run) {
			front = br.readLine();
			if(front.equals("0")) {
				run = false;
				break;
			}
			l = front.length();
			back = new char[l];

			for (int i = 0 ; i < l ; i++) {
				back[l-1-i] = front.charAt(i);
			}
      // Java에서 String을 비롯한  내용 비교는 무조건 equals!!
			if (front.equals(String.valueOf(back))) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
