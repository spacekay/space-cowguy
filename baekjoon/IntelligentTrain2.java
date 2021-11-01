import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IntelligentTrain2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int cnt=0;
		int max=0;
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int out=Integer.parseInt(st.nextToken());
			int in=Integer.parseInt(st.nextToken());
			cnt-=out;
			cnt+=in;
			if(max<cnt)
				max=cnt;
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
	}
}
