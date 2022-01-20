import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Stick {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x = Integer.parseInt(br.readLine());
		br.close();
		int sum = 64;
		PriorityQueue<Integer> sticks = new PriorityQueue<>();
		sticks.offer(64);
		while(sum>x) {
			if(sum>x) {
				int stick = sticks.poll();
				stick /= 2;
				sum-=stick;
				sticks.offer(stick);
				if(sum<x) {
					sum+=stick;
					sticks.offer(stick);
				}	
			}
		}	
		bw.write(sticks.size()+"\n");
		bw.flush();
		bw.close();
	}
}
