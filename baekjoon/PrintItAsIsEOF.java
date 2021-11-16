import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrintItAsIs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String now;
		while((now=br.readLine()) != "" && now != null) {
			bw.write(now+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
