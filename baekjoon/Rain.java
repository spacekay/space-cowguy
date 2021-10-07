import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Rain {
	static int[] height;
	static int left = 0;
	static int right;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());		
		height = new int[w];
		right = w-1;
		int[][] save = new int[w][2];
		int sum = 0;
		st = new StringTokenizer(br.readLine()," ");
		// 구현 문제는 아이디어 찾기가 중요
		// 초기화할 때 항상 주의. 검색기능 사용하려면 무조건 데이터 다 넣은 후에
		for(int i=0;i<w;i++) {
			height[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<w;i++) {
			save[i][0]=checkLeft(i);
			save[i][1]=checkRight(i);
			int minH;
			if(i!=0 && i!=w-1) {
				if((minH=Math.min(save[i][0], save[i][1]))>height[i]) {
					sum+=(minH-height[i]);
				}
			}	
		}
		br.close();
		bw.write(sum+"\n");
		bw.flush();
		bw.close();
	}
	public static int checkLeft(int n) {
		int maxH=height[0];
		for(int i=0;i<n;i++) {
			if(maxH<height[i]) {
				maxH=height[i];
				left=i;
			}
		}
		return maxH;
	}
	public static int checkRight(int n) {
		int w=height.length;
		int maxH=height[w-1];
		for(int i=w-1;i>n;i--) {
			if(maxH<height[i]) {
				maxH=height[i];
				right=i;
			}
		}
		return maxH;
	}
}
