import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AntOnStick {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
    // 개미가 어느쪽으로 갈 수 있건.. 최소값이나 최대값이 나오는 조건은 동일하다.
    // 가장 가장자리에서 먼 개미가 중간에 방향 안바꾸고 쭉 끝까지 가는 경우가 최소값이고
    // 가장 가장자리에 가까운 개미가 반대편 끝까지 쭉 가는 경우가 최대값이다.
    // Loop를 시키는 것도 한계가 있다. 모든 개미들은 계속 움직이고, 결국 모두의 위치는 끝을 향해 수렴하기 때문이다.
    
    for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			double max = 0;
			int minP = l;
			int maxP = 0;
			double mid = l/2;
			double min = l;
			for(int j=0;j<n;j++) {
				int now = Integer.parseInt(br.readLine());
				if(Math.abs(mid-now)>=max) {
					max = Math.abs(mid-now);
					maxP = now;
				}
				if(Math.abs(mid-now)<=min) {
					min = Math.abs(mid-now);
					minP = now;
				}
			}
			
			int minT = 0;
			int maxT = 0;
			
			if(minP>mid) {
				minT = l-minP;
			} else {
				minT = minP;
			}
			
			if(maxP<mid) {
				maxT = l-maxP;
			} else {
				maxT = maxP;
			}
			
			bw.write(minT+" "+maxT+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
