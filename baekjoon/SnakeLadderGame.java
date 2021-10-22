import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeLadderGame {
	static HashMap<Integer,Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int all = n+m;
		map = new HashMap<>();
		for(int i=0;i<all;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int arrive=Integer.parseInt(st.nextToken());
			map.put(start, arrive);	
		}
		br.close();
    // 최적 경로 찾기 -> BFS (간선 간 가중치 동일할 경우)
		bw.write(BFS()+"\n");
		bw.flush();
		bw.close();
	}
	public static int BFS() {
		Queue<Item> q = new LinkedList<>();
		boolean[] visited = new boolean[101];
		q.offer(new Item(1,0));
		visited[0]=visited[1]=true;
		int min=1000000;
		while(!q.isEmpty()) {
			Item now = q.poll();
			int a=now.arrive;
			int c=now.cnt;
			// 큐 한 사이클이 가지고 있는 모든 원소의 cnt값은 모두 동일해야 break를 먹였을 때 진짜 최소값이 나옴
			if(a==100) {
				min=c;
				break;
			}
			for(int i=1;i<7;i++) {
				if(a+i>100)
					break;
				else if(visited[a+i])
					continue;
				else if(map.containsKey(a+i)) {
					int tmp=map.get(a+i);
					if(visited[tmp])
						continue;
					q.offer(new Item(tmp,c+1));
					visited[tmp]=true;
				}		
				else {
					q.offer(new Item(a+i,c+1));
					visited[a+i]=true;
				}	
			}
		}
		return min;
	}
	static class Item{
		int arrive;
		int cnt;
		public Item(int b, int c) {
			arrive=b;
			cnt=c;
		}
	}
}
