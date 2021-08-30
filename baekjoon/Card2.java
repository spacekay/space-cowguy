import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 0 ; i < n ; i++) {
			que.offer(Integer.valueOf(i+1));
		}
    // 아래 while 문은 que.size()가 2 이상이어야 작동 가능하나, 입력 범위에는 1도 포함된다.
    // 예외 케이스에 대해서도 처리할 수 있도록 한다.
		if (que.size() == 1) {
			bw.write(que.poll()+"\n");
		} else {
			while (!que.isEmpty()) {
				que.poll();
				que.offer(que.poll());
				if (que.size() == 1) {
					bw.write(que.poll()+"\n");
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
