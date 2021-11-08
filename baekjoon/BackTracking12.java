import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BackTracking12 {
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
		boolean[][] letter = new boolean[m][10001];
		DFS(0,0,result,letter);
		bw.flush();
		bw.close();
	}
	public static void DFS(int level, int a, String result, boolean[][] letter) throws IOException {
		if(level==m) {
			bw.write(result+"\n");
		} else {
			if (level>0)
				result+=" ";
			// 이전 실행에서 사용한 숫자들이 방문처리 되어 있는 상태임
			// 이번 레벨에 한해서는 다시 모든 숫자를 사용 가능하게 만들어야 함
			Arrays.fill(letter[level], false);
			for(int i=a;i<n;i++) {
				if(!letter[level][arr[i]]) {			
					// 이전에 true로 만든 letter 배열이 전달됨
					DFS(level+1, i, result+Integer.toString(arr[i]), letter);	
					// 이번 실행에서만 사용하고, 다음 실행에는 반영하지 않아야 함
					letter[level][arr[i]] = true;
				}
			}
		}
	}
}
