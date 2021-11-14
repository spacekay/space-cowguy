import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FillingStation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long[] city = new long[n];
		long[] road = new long[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n-1;i++) {
			road[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		long cost = 0;
		city[0] = Long.parseLong(st.nextToken());
		// 우변 연산을 하는 동안에 city 쪽 자료형 범위를 넘을 수 있음
		// 입력은 int로 받을 수 있으나 이후 모든 연산할 때 주의해야 함
		cost+=city[0]*road[0];
		int nowIndex = 0;
		for(int i=1;i<n-1;i++) {
			city[i] = Long.parseLong(st.nextToken());
			if(city[i]<city[nowIndex]) {
				nowIndex = i;
			}
			cost+=city[nowIndex]*road[i];
		}
		city[n-1] = Long.parseLong(st.nextToken());
		bw.write(cost+"\n");	
		bw.flush();
		bw.close();
	}
}
