import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TrackOneCycle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int d=Integer.parseInt(br.readLine());
		int r=Integer.parseInt(br.readLine());
		final double pi = 3.141592;
		bw.write((2*d+2*pi*r)+"\n");
		bw.flush();
		bw.close();
	}
}
