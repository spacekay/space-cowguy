import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MovieDirector {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int save = 0;
		int s = 666;
		int t = 0;
		String S = "";
		while (t < n) {
			S = Integer.toString(s);
			if (S.indexOf("666")>=0) {
				save = s;
				t++;
			}
			s++;
		}
		bw.write(save+"\n");
		bw.flush();
		bw.close();
	}
}
