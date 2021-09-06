import java.io.*;
import java.util.*;

public class CuttingWood {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		// 대체로 데이터 타입은 크게 줘야 한다. (문제 조건 상 10억 단위까지 감)
		long m = Long.parseLong(st.nextToken());
		long save = 0;
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		long max = 0;
		// 1차원 배열이라 그나마 배열로 쓰긴 하지만..
		for (int i=0;i<n;i++) {
			arr[i] = Long.parseLong(st.nextToken());
			if (arr[i]>max) {
				max = arr[i];
			}
		}
		long mid = 0;
		long min = 0;
		long sum;
		// O^2 정렬을 해버리는 순간 시간초과가 발생할 것이므로 Binary Search를 실행한다.
		// 목표는 최종 출력값(절단기의 높이 H) 구하기이며, H의 가능한 최소값은 0부터 지정한다.
		// mid의 범위는 계속 변화한다.
		while (min <= max) {
			sum = 0;
			mid = (min+max)/2;
			// 일단은 해답에 가까운 범위로 계속 접근해 간다
			for(int i=0;i<n;i++) {
				if (arr[i]>=mid)
					sum+=(arr[i]-mid);
			}
			// 좀 더 낮은 곳에서 잘라야 한다
			if (sum<m) {
				max = mid-1;
			} else { // 좀 더 높은 곳에서 잘라야 할수도, 아니면 여기가 사실 딱 맞는 거였을수도
				// 어느쪽인지는 while문의 조건이 만족할 때까지 굴린 후에 판단한다.
				min = mid+1;
				// 이왕이면 높을수록 좋으니까
				save = save > mid ? save : mid;
			}		
		}
		bw.write(save+"\n");
		bw.flush();
		bw.close();
	}
}
