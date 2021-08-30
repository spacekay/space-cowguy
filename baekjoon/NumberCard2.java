import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// String으로 받아도 되는 케이스라면 굳이 parseInt 안 거치는게 더 빠르다.
		HashMap<String, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String save;
		int value;
		for (int i = 0 ; i < n ; i++) {
			save = st.nextToken();
			if (map.containsKey(save)) {
				value = map.get(save);
				// replace보다는 put이 더 빠르다.
				map.put(save, value+1);
			} else {
				map.put(save, 1);
			}		
		}
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < m ; i++) {
			save = st.nextToken();
			//  출력값 개수가 많을 때에는, sb의 저장 한도가 허락하는 범위에서 bw보다 sb가 더 빠르다.
			if (map.containsKey(save)) {
				sb.append(map.get(save)+" ");
			} else {
				sb.append(0+" ");
			}	
		}		
		System.out.println(sb.toString());
		br.close();
	}
}
