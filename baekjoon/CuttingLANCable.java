package binary0;

import java.io.*;
import java.util.StringTokenizer;

public class CuttingLANCable {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long max = 0;
		for(int i=0;i<k;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (max < arr[i])
				max = arr[i];
		}
		br.close();
		long min = 0;
		long mid = 0;
		long sum;
		long save = 0;
		while (min <= max) {
			sum = 0;
			// mid를 구하는 과정에서 int 범위 초과할 수 있을 것으로 추측한다. (다른 부분은 예상가지 않음..)
			mid = (min+max)/2;
			if(mid == 0)
				mid = 1;
			for(int i=0;i<k;i++) {
				sum+=(arr[i]/mid);
			}
			if (sum<n) {
				max = mid-1;
			} else {
				min = mid+1;
				save = save > mid ? save : mid;
			}		
		}
		if(k==1) {
			save = arr[0]/n;
		}			
		bw.write(save+"\n");	
		bw.flush();
		bw.close();
	}
}
