package blog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DSLR {
	static Commands result;
	static String[] results=new String[10000];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			BFS(a,b);
			bw.write(results[result.n]+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
  // 온갖 종류의 초기화의 중요성을 느낀 문제
	public static void BFS(int a, int b) {
		Queue<Commands> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];
		visited[a]=true;
		q.offer(new Commands(a));
		results[a]="";
		while(!q.isEmpty()) {
			Commands save=q.poll();
			int n=save.n;
			Commands didD=new Commands(n);
			int k = didD.getD();
			if(!visited[k]) { 
				// 일종의 DP 응용
				visited[k]=true;
				results[k]=results[n]+"D";
				if(k==b) {
					result=didD;
					return;
				}
				q.offer(didD);
			}
			Commands didS=new Commands(n);
			k = didS.getS();
			if(!visited[k]) { 
				visited[k]=true;
				results[k]=results[n]+"S";
				if(k==b) {
					result=didS;
					return;
				}
				q.offer(didS);
			}
			Commands didL=new Commands(n);
			k = didL.getL();
			if(!visited[k]) { 
				visited[k]=true;
				results[k]=results[n]+"L";
				if(k==b) {
					result=didL;
					return;
				}
				q.offer(didL);
			}
			Commands didR=new Commands(n);
			k = didR.getR();
			if(!visited[k]) { 
				visited[k]=true;
				results[k]=results[n]+"R";
				if(k==b) {
					result=didR;
					return;
				}
				q.offer(didR);
			}
		}
	}
  // 별도 클래스 없이 int로만 처리해서 아래의 모든 함수들을 static 함수로 푼다면 속도가 올라갈까?
  // 당연히 올라갈 것이므로 확인해서 재커밋 예정
	static class Commands{
		int n;
		public Commands(int n) {
			this.n=n;
		}
		public int getD() {
			this.n*=2;
			if(this.n>=10000) {
				this.n%=10000;
			}
			return this.n;
		}
		public int getS() {
			if(this.n==0)
				this.n=9999;
			else
				this.n-=1;
			return this.n;
		}
		public int getL() {
			String N = Integer.toString(n);
			int[] oldNum = new int[4];
			for(int i=4-N.length();i<4;i++) {
				oldNum[i]=N.charAt(i-4+N.length())-'0';
			}
			int[] num=oldNum.clone();
			for(int i=0;i<4;i++) {
				if(i==3) {
					num[i]=oldNum[0];
				} else  {
					num[i]=oldNum[i+1];
				}
			}
			this.n=num[0]*1000+num[1]*100+num[2]*10+num[3];
			return this.n;
		}
		public int getR() {
			String N = Integer.toString(n);
			int[] oldNum = new int[4];
			for(int i=4-N.length();i<4;i++) {
				oldNum[i]=N.charAt(i-4+N.length())-'0';
			}
			int[] num=oldNum.clone();
			for(int i=0;i<4;i++) {
				if(i==0) {
					num[i]=oldNum[3];
				} else  {
					num[i]=oldNum[i-1];
				}
			}
			this.n=num[0]*1000+num[1]*100+num[2]*10+num[3];	
			return this.n;
		}
	}
}
