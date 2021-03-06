import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindPassword {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
    // HashMap 쓰고 br bw 쓴 것이 핵심
		HashMap<String, String> map=new HashMap<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			map.put(st.nextToken(), st.nextToken());
		}
		for(int i=0;i<m;i++) {
			bw.write(map.get(br.readLine())+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
