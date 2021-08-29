import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

// LinkedList에 비해 조금 더 느리고 메모리 더 차지하긴 한다. 큰 차이는 아니다.
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		TreeSet<Integer> tset = new TreeSet<Integer>();
		
		for (int i = 0 ; i < n ; i++) {
			tset.add(Integer.parseInt(br.readLine()));
		}
		
		for (Integer one : tset) {
			bw.write(one+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
