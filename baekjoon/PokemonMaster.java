import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class PokemonMaster {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr =  new String[n];
		// 원래 배열의 index 위치도 알아야 하기 때문에 String을 Hash로 구현하여 속도를 향상시킬 수 있는 HashMap 사용
		// 일반 해쉬맵보다 LinkedHashMap이 더 get method 빠름
		LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine();
			map.put(arr[i], i);
		}
		for(int i=0;i<m;i++) {
			String input=br.readLine();
			if (input.charAt(0)<='9') {
				int index = Integer.parseInt(input);
				// 어차피 value 찾는 것은 오래 걸리므로 이건 별도 배열로 구하는게 더 빠름 (메모리 여유만 있다면)
				bw.write(arr[index-1]+"\n");
			} else {
				int index=map.get(input)+1;
				bw.write(index+"\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
