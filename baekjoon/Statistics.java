import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Statistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int min = 4001;
		int max = -4001;
		int save = 0;
		long sum = 0;
		for(int i=0;i<n;i++) {
			arr[(save = Integer.parseInt(br.readLine()))+4000]++;
			sum += save;
			if (save > max) {
				max = save;
			}
			if (save < min) {
				min = save;
			}
		}
		br.close();	
		int[] sorted = arr.clone();
		Arrays.sort(sorted);
		int mostFreq = sorted[8000];
		int avg = 0;
    // 데이터 타입에 따라 민감하게 반응할 수 있는 나눗셈 -> 평균 구하기에 
		if (sum > 0)
			avg = (int) ((double) sum/ (double) n +0.5);
		else 
			avg = (int) ((double) sum/ (double) n -0.5);
		int mid = 0;
		int fIndex = 0;
		sum = 0;
		int t = 0;
		boolean flag = true;
		for (int i=min+4000;i<max+4001;i++) {
			sum += arr[i];
			if (sum > n/2 && flag) {
				mid = i-4000;
				flag = false;
			}
			if(arr[i]>=mostFreq && t < 2) {
				fIndex = i-4000;
				t++;
			}
		}		
		int range = max-min;		
		bw.write(avg+"\n");
		bw.write(mid+"\n");
		bw.write(fIndex+"\n");
		bw.write(range+"\n");
		bw.flush();
		bw.close();
	}
}
