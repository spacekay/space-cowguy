import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MergeArrays {
  // PriorityQueue
	/*public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine()," ");
		br.close();
		for(int i=0;i<m;i++) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		while(!q.isEmpty()) {
			bw.write(q.poll()+" ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}*/
  
  // Array 3개
  	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n];
		int[] b = new int[m];
		int[] ab = new int[n+m];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		br.close();
		for(int i=0;i<m;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		int ai = 0, bi = 0, index=0;
		while(ai<n && bi<m) {
			if(a[ai]==b[bi]) {
				// 두 번 써주기
				ab[index++] = a[ai++];
				ab[index++] = b[bi++];
			} else if(a[ai]<b[bi]) {
				ab[index++] = a[ai++];
			} else {
				ab[index++] = b[bi++];
			}
		}
		if(ai<n) {
			while(ai<n) {
				ab[index++] = a[ai++];
			}
		} else {
			while(bi<m) {
				ab[index++] = b[bi++];
			}
		}
		for(int one : ab) {
			bw.write(one+" ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
