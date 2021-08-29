import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] save = new String[n];

		for (int i = 0 ; i < n ; i++) {
			save[i] = br.readLine();
		}
  
    // Array로 처리할 정도의 입력 범위라서 Comparater 생로 처리
		Arrays.sort(save, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() > o2.length()) {
					return 1;
				} else if (o1.length() < o2.length()) {
					return -1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		
		String pre = "";
		for (String one : save) {
			if (one.equals(pre)) {
				continue;
			} else {
				bw.write(one+"\n");
				pre = one;
			}	
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
