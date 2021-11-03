import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackTracking8 {
	static int n;
	static int m;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
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
		Arrays.sort(arr);
		String result="";
		DFS(0,result,0);
		bw.flush();
		bw.close();
	}
	public static void DFS(int level, String result, int a) throws IOException {
		if(level==m) {
			bw.write(result+"\n");
		} else {
			if (level>0)
				result+=" ";
			for(int i=a;i<n;i++) {
				DFS(level+1, result+Integer.toString(arr[i]), i);	
			}
		}
	}
}
