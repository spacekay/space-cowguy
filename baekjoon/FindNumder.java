import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
    // 값의 정렬이 필요하지 않고 그냥 유무만 확인하려 하면 해시셋 쓰는 것도 빠른 편
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0 ; i < n ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		int m = Integer.parseInt(br.readLine());
		Integer x;
		st = new StringTokenizer(br.readLine(), " ");
    
    // Binary Search 사용하며 풀기 위해서는 원소 하나하나를 검증하는 방식으로 해야 함
    // 내가 시간초과 나왔던 방식은 Quick Sort
		for (int i = 0 ; i < m ; i++) {
			x = Integer.parseInt(st.nextToken());
			if(set.contains(x)) {
				bw.write(1+"\n");
			} else {
				bw.write(0+"\n");
			}
		}	
		bw.flush();
		bw.close();
		br.close();
	}
}
