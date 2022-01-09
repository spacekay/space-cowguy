import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrintBy10 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String word = br.readLine();
		br.close();
		for(int i=0;i<word.length();i++) {
			bw.write(word.charAt(i));
			if(i%10==9)
				bw.write("\n");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}

}
