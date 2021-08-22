import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<String> list = new LinkedList<String>();
		for (int i = 0 ; i < n ; i++) {
			list.add(String.valueOf(i+1));
		}
		sb.append("<");
		int t = k-1;
		while (!list.isEmpty()) {
			String In = list.remove(t);
			sb.append(In);
			t += k-1;	
			while (list.size() > 0) {
				if (t >= list.size())
					t -= list.size();				
				if (t < list.size())
					break;
			}
			if (!list.isEmpty())
				sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());		
		br.close();
	}
}
