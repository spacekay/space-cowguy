import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class OperatorAdding {
	static int n;
	static int[] arr;
	// 초기값 범위 & 자료형 주의
	static long max=-1000000001;
	static long min=1000000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int[] operator = new int[4];
		// +:0, -:1, x:2, /:3
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<4;i++) {
			operator[i]=Integer.parseInt(st.nextToken());
		}
		DFS(1, arr[0], operator);
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
	public static void DFS(int level, long result, int[] operator) {
		if(level==n) {	
			if(max<result)
				max=result;
			if(min>result)
				min=result;
		} else {
			// 앞에서 배열 값을 건드린 것은 다시 복구해서 다음 판정 때 써먹어야 함
			if(operator[0]>0) {
				operator[0]--;
				DFS(level+1,result+arr[level],operator);
				operator[0]++;
			}
			if(operator[1]>0) {
				operator[1]--;
				DFS(level+1,result-arr[level],operator);
				operator[1]++;
			}
			if(operator[2]>0) {
				operator[2]--;
				DFS(level+1,result*arr[level],operator);
				operator[2]++;
			}
			if(operator[3]>0) {
				operator[3]--;
				DFS(level+1,result/arr[level],operator);
				operator[3]++;
			}
		}	
	}
}
