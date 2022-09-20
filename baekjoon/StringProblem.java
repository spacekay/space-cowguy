import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringProblem {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		char[] c = new char[2];

		for(int t=0;t<T;t++) {
			String now = br.readLine();
			
			c[0] = now.charAt(0);
			c[1] = now.charAt(now.length()-1);
			String result = new String(c);
			
      // char를 바로 출력하면 아스키 코드로 출력될 수 있어 주의
			bw.write(result+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
