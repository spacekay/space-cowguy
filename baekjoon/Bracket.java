import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bracket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] save = new String[n];
		boolean[] flag = new boolean[n];
		for (int i = 0; i < n ; i++) {
			save[i] = br.readLine();
			while(save[i].contains("()")) {
				save[i] = save[i].replace("()", "");
			}
			if (save[i].length() == 0) {
				flag[i] = true;
			}
		}

		for (int i = 0 ; i < n ; i++) {
			if (flag[i])
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}	
		bw.flush();
		bw.close();
		br.close();
	}
}
