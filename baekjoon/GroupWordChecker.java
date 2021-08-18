import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class GroupWordChecker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int x = Integer.parseInt(br.readLine());
		int t = 0;

		for (int i = 0 ; i < x ; i++) {
			String word = br.readLine();
			char char_present = word.charAt(0);
			int l = word.length();
			boolean flag = false;
			List<String> list = new ArrayList<String>();
			for (int j = 0 ; j < l ; j++) {
				if (char_present == word.charAt(j)) {
					list.add(Character.toString(word.charAt(j)));
				} else if (list.contains(Character.toString(word.charAt(j)))) {
					flag = true;
					break;
				} else {
					list.add(Character.toString(word.charAt(j)));
					char_present = word.charAt(j);
				}
			}
			if (!flag)
				t++;
		}
		sb.append(t);
		System.out.println(sb);
		br.close();
	}
}
