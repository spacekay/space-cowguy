import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackTracking5 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] arr;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.sort(arr);
		String result="";
		boolean[] visit = new boolean[n];
		DFS(0, result, visit);
		bw.flush();
		bw.close();
	}
  // Array index와 실제 값을 혼동하지 말자
	public static void DFS(int level, String result, boolean[] visit) throws IOException {
		if(level==m) {
			bw.write(result+"\n");
		} else {
			if (level>0)
				result+=" ";
			for(int i=0;i<n;i++) {
				if(!visit[i]) {
					visit[i]=true;
					DFS(level+1, result+Integer.toString(arr[i]), visit);
					visit[i]=false;
				}	
			}
		}
	}
}
