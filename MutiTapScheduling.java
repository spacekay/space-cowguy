import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MutiTapScheduling {
	static int[] save;
	static int[][] tap;
	static int n;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		save = new int[k+1];
		tap = new int[2][n];
		for(int i=0;i<k;i++) {
			save[i]=Integer.parseInt(st.nextToken());
		}		
		br.close();
		int cnt=0;
		for(int i=0;i<k;i++) {
			boolean flag = false;
			for(int j=0;j<n;j++) {
				// 멀티탭 꽂을 자리가 없을 때만 뽑음
				if(tap[0][j]==save[i]) {
					flag = true;
					break;
				}
				if(tap[1][j]==0) {
					tap[1][j]=1;
					tap[0][j]=save[i];
					flag = true;
					break;
				}
			}
			if(!flag) {
				// 다시 한바퀴 돌면서 어디든 꽂혀있는지 확인
				int check = checktap(save[i]);
				// binarySearch 내장함수는 배열이 정렬되어 있지 않은 경우 사용하면 안됨
				if(check==-1) {
					int max=0;
					int tapIndex=0;
					for(int j=0;j<n;j++) {
						int index = checkRightIndex(i, tap[0][j]);
						if(index>max) {
							max=index;
							tapIndex=j;
						}
					}
					tap[0][tapIndex] = save[i];
					cnt++;
				}
			}
		}	
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
	// 필요한 기능이 있다면 귀찮더라도 함수로 만들어서 구현하기
	public static int checktap(int a) {
		int result = -1;
		for(int i=0;i<n;i++) {
			if(tap[0][i]==a) {
				result = i;
				break;
			}
		}
		return result;
	}
	public static int checkRightIndex(int a, int b) {
		int result = 101;
		for(int i=a+1;i<k;i++) {
			if(save[i]==b) {
				result = i;
				break;
			}
		}
		return result;
	}
}
