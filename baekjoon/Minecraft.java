import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Minecraft {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] height = new int[n][m];
		
		// 가장 높은 높이부터 낮은 높이까지 모든 자연수 경우의 수를 테스트해야함
		int maxH=0;
		int minH=300;		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0 ; j <m ; j++) {
				height[i][j] = Integer.parseInt(st.nextToken());
				maxH=Math.max(maxH, height[i][j]);
				minH=Math.min(minH, height[i][j]);
			}
		}
		br.close();
		// TreeMap처럼 시간 오래 걸리는 것을 쓰기보다는 그냥 단순하게 변수로만 값을 구하는 연습도 하자
		// 각 변수의 최댓값 등 범위 파악도 신중해야 함
		// long보다는 int가 메모리도 적게 먹고 더 빠름
		int resultT=600*500*500;
		int resultH=0;
		outer:
			for(int h=minH;h<=maxH;h++) {
				int leftB = b;
				int t=0;
				for(int i=0;i<n;i++) {
					for(int j=0;j<m;j++) {
						if(h>height[i][j]) {
							leftB-=(h-height[i][j]);
							t+=(h-height[i][j]);
						} else if (h<height[i][j]) {
							leftB+=(height[i][j]-h);
							t+=(height[i][j]-h)*2;
						}
					}			
				}
				// 일단 한바퀴 다 돌리고 나서 마이너스가 나오는 조건인 경우만 map에 결과 넣지 않음
				if(leftB<0) {
					continue outer;
				}
				if(resultT>t) {
					resultT=t;
					resultH=h;
				} else if (resultT==t){
					if(resultH<h) {
						resultH=h;
					}
				}
			}
		bw.write(resultT+" "+resultH+"\n");
		bw.flush();
		bw.close();
	}
}
