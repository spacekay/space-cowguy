package sort0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CoordinateCompression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<n;i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		// 이 과정을 수동으로 해야 덜 느려질듯
		HashSet<Integer> set = new HashSet<>(queue);
		LinkedList<Integer> list = new LinkedList<>(set);
		Collections.sort(list);
		int print;
		int save;
		while(!queue.isEmpty()) {
			save = queue.poll();
			// indexOf 함수가 시간을 많이 잡아먹는다는듯
			print = list.indexOf(save);
			bw.write(print+" ");
		}		
		br.close();
		bw.flush();
		bw.close();
	}
}
