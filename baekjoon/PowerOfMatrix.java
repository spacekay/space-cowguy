import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PowerOfMatrix {
  
	static int[][] arr, unitArr;
	static int n;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
    
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		arr = new int[n][n];
		unitArr = new int[n][n];
    
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken())%1000;
				if(i==j)
					unitArr[i][j] = 1;
			}
		}
		
		int[][] fin = pow(b);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				bw.write(fin[i][j]+" ");
			}
			bw.write("\n");
		}		
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int[][] pow (long b) {
		if(b==0) {
			return unitArr;
		} else if(b==1) {
			return arr;
		}
		
		// 분할정복 사용
		int[][] half = pow(b/2);
		int[][] result = powMatrix(half, half);
		
		if(b%2==0) {
			return result;
		} else {
			return powMatrix(result, arr);
		}		
	}
	
	public static int[][] powMatrix(int[][] now, int[][] more) {
		
		int[][] result = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					result[i][j] += now[i][k]*more[k][j];
					result[i][j] %= 1000;
				}
			}
		}
		return result;
	}

}
