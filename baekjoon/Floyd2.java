import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd2 {

	static int[][] cost;
	static int[][] bus;
	static int[][] visit;
	static int n;
	static int m;
	static ArrayList<Integer> visits = new ArrayList<>();
	static final int MAX = 10_000_001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		n = Integer.parseInt(br.readLine());
		cost = new int[n+1][n+1];
		visit = new int[n+1][n+1];

		for(int i=0;i<n+1;i++) {
			Arrays.fill(cost[i], MAX);
			cost[i][i] = 0;
		}

		m = Integer.parseInt(br.readLine());
		bus = new int[m+1][3];

		StringTokenizer st;
		for(int l=1;l<m+1;l++) {
			st = new StringTokenizer(br.readLine(), " ");
			bus[l][0] = Integer.parseInt(st.nextToken());
			bus[l][1] = Integer.parseInt(st.nextToken());
			bus[l][2] = Integer.parseInt(st.nextToken());
		}
		br.close();	

		findNext();		

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(cost[i][j]>=MAX)
					bw.write("0 ");
				else
					bw.write(cost[i][j]+" ");
			}
			bw.write("\n");
		}

		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(i==j || cost[i][j]==MAX)
					bw.write("0\n");
				else {
					visits.clear();
					visits.add(i);
					findRoute(i,j);
					visits.add(j);
					bw.write(visits.size()+" ");
					for(int k=0;k<visits.size()-1;k++) {
						bw.write(visits.get(k)+" ");
					}
					bw.write(j+"\n");			
				}
			}
		}
		bw.flush();
		bw.close();
	}

	static void findNext() {

		boolean[] checked = new boolean[m+1];

		for(int i=1;i<n+1;i++)
			for(int k=1;k<m+1;k++) {
				if(!checked[k] && bus[k][0]==i) {
					cost[i][bus[k][1]] = Math.min(bus[k][2], cost[i][bus[k][1]]);
					checked[k] = true;
				}
			}

		for(int i=1;i<n+1;i++)
			for(int j=1;j<n+1;j++)
				for(int k=1;k<n+1;k++) {
					// i를 거쳐가는 비용과 현재 비용 중 더 저렴한 경우를 계속 선택함
					if(cost[j][k] > cost[j][i]+cost[i][k]) {
						cost[j][k] = cost[j][i]+cost[i][k];
            // 경유지 표현
						visit[j][k] = i;
					}
				}		
	}

	static void findRoute(int start, int end) {
		if(visit[start][end]==0) {
			return;
		} else {
			findRoute(start, visit[start][end]);
			visits.add(visit[start][end]);
			findRoute(visit[start][end], end);
		}
	}
}
