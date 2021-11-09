import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Polyhedron {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine()," ");
			// 면의 수 = 2+모서리-꼭짓점
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			bw.write((2+e-v)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
