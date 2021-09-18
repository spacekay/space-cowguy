package graph0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());				
		br.close();

		int time=BFS(n,k);
		System.out.println(time);		
	}	
  
	private static int BFS(int n, int k) {
		int max;
		if(n>k) {
			max=n;
		} else {
			max=k;
		}
		Queue<Integer> bfs = new LinkedList<Integer>();
		bfs.add(n);
		int[] distance=new int[max+2];
		Arrays.fill(distance, -1);
		distance[n]=0;
		while (!bfs.isEmpty()) {
			// for문으로 돌리기보다는, 꼭 지나가야 하는 node만 탐색하는 것이 합리적
			int v = bfs.poll();
			if(v==k) {				
				break;
			}
			// BFS는 모든 경우의 수를 한번 죽 훑고 가는 것이 포인트이므로
			// 병렬 if문을 사용하여 모든 경우를 queue 안에 넣어준다.
			if (v-1>=0 && distance[v-1]==-1) {
				bfs.offer(v-1);
				distance[v-1]=distance[v]+1;
			}
			if (v+1<=max+1 && distance[v+1]==-1) {
				bfs.offer(v+1);
				distance[v+1]=distance[v]+1;
			}
			if (v*2<=max+1 && distance[v*2]==-1) {
				bfs.offer(v*2);
				distance[v*2]=distance[v]+1;
			}
		}
		return distance[k];
	}
}
