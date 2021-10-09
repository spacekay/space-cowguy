import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 정말 오랜만에 풀어본 기하 문제
public class TheLittlePrince {
	static int[] path;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int l=0;l<T;l++) {
			st = new StringTokenizer(br.readLine()," ");
			path = new int[4];
			for(int i=0;i<4;i++) {
				path[i]=Integer.parseInt(st.nextToken());
			}
			int n = Integer.parseInt(br.readLine());		
			int sum=0;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				sum+=checkInOut(x,y,r);
			}
			bw.write(sum+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
	public static int checkInOut(int x, int y, int r) {
		int result=0;
		double value = 0;
		// 각 행성계별로 시작점과 도착점을 포함하고 있는지 확인
		// 어차피 시작점과 도착점이 반드시 포함되지 않는 행성계라면 어떻게든 피해서 지나갈 수도 있음
		// 자기들끼리 겹쳐있거나 하여도 시작점이나 도착점이 거기에 포함되어있지 않다면 그쪽으로 갈 이유가 없음
		// 돌아서라도 가면 되니까...
		for(int i=0;i<4;i++) {
			if(i%2==0) {
				value += (path[i]-x)*(path[i]-x);
			} else {
				value += (path[i]-y)*(path[i]-y);
				if(value<=r*r) {
					result++;
				}
				value=0;
			}
		}
		// 이 말인 즉슨 두 점이 같은 행성계에 포함되어 있다는 뜻이다. 이 행성계 밖을 나갈 필요는 없다.
		// 최대한 행성계의 안팎을 드나드는 것을 줄여야 하기 때문이다.
		if(result==2)
			result=0;
		return result;
	}
}
