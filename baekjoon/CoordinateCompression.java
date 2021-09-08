import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoordinateCompression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] newArr = arr.clone();
		Arrays.sort(newArr);
		
		//Arrays.binarySearch method 활용 알고리즘 (기본 용도는 Arrays에서 index 찾기)
		//(조건만 준비되어 있다면 필요한 index 찾는 데에는 Collection에서의 indexOf보다 훨씬 빠름)
		// newArr의 중복 원소 없애기 (정렬된 배열 기준으로만 가능)
		/*int[] result = new int[n];
		result[0] = newArr[0];
		int t = 1;
		for(int i=1;i<n;i++) {
			if(result[t-1]!=newArr[i]) {
				result[t]=newArr[i];
				t++;
			}
		}
		int print;
		for(int i=0;i<n;i++) {
			print = Arrays.binarySearch(result, 0, t, arr[i]);
			bw.write(print+" ");
		}*/
		
		// HashMap 활용 알고리즘 (treemap은 엄청나게 느리므로 신중하게 사용)
		int t = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if (!map.containsKey(newArr[i])) {
				map.put(newArr[i], t++);
			}
		}
		for(int i=0;i<arr.length;i++) {
			bw.write(map.get(arr[i])+" ");
		}	
		
		
		br.close();
		bw.flush();
		bw.close();
	}
}
