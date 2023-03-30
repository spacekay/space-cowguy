import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharAndString {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String S = br.readLine();
		int n = Integer.parseInt(br.readLine());
		br.close();
//		bw.write(S.charAt(n-1)+"\n");
		System.out.println(S.charAt(n-1));	
//		bw.flush();
//		bw.close();
	}
}
