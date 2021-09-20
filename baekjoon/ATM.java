import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			time[i]=Integer.parseInt(st.nextToken());	
		}
		br.close();
		// 소요시간이 짧은 사람부터 시작하는게 무조건 이득
		Arrays.sort(time);
		// 총 합과 각자 끝내기까지 소요된 시간 따로 카운트
		int t=0;
		int save=0;
		for(int i=0;i<n;i++) {
			save+=time[i];
			t+=save;
		}
		bw.write(t+"\n");
		bw.flush();
		bw.close();
	}
}
