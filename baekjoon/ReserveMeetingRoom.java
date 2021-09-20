package greedy0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ReserveMeetingRoom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		int[][] reserve = new int[n][2];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			reserve[i][0]=Integer.parseInt(st.nextToken());
			reserve[i][1]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(reserve, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// 더 빨리 끝나는 원소부터 반복문에 등장하도록 설계
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				} else {
					return o1[1]-o2[1];
				}
			}		
		});
		
		// 초기값으로 무조건 회의 하나는 열게 됨
		int t=1;
		int time=reserve[0][1];
		// 빨리 끝나는 회의부터 정렬해서 먼저 처리하면 최대한 많은 회의를 개최할 확률이 증가 (Greedy Algorithm!)
		for(int i=1;i<n;i++) {
			// 이전 회의 끝나는 시간보다 늦게 시작하는 회의만 확인
			if(reserve[i][0]>=time) {
				time=reserve[i][1];
				t++;
			}
		}
		bw.write(t+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
