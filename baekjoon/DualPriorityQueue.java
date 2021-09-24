import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// 미완성
public class DualPriorityQueue {
	static PriorityQueue<Integer> minQ;
	static PriorityQueue<Integer> maxQ;
	static PriorityQueue<Integer> tempMinQ;
	static PriorityQueue<Integer> tempMaxQ;
	static int size=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		minQ = new PriorityQueue<>();
		maxQ = new PriorityQueue<>(Comparator.reverseOrder());
		tempMinQ = new PriorityQueue<>();
		tempMaxQ = new PriorityQueue<>(Comparator.reverseOrder());
		String[] save;
		for(int i=0;i<T;i++) {
			size=0;
			int k=Integer.parseInt(br.readLine()); 
			for(int j=0;j<k;j++) {
				save=br.readLine().split(" ");
				int n=Integer.parseInt(save[1]);
				switch(save[0].charAt(0)) {	
				case 'I':				
					offerQ(n);
					break;
				case 'D':
					if(n==1) {
						pollMax();
					} else if (n==-1) {
						pollMin();
					}
					break;
				}						
			}
			if(size==0) {
				bw.write("EMPTY\n");
			} else {
				bw.write(maxQ.peek()+" "+minQ.peek()+"\n");
			}
			minQ.clear();
			maxQ.clear();
			tempMinQ.clear();
			tempMaxQ.clear();
		}
		br.close();	
		bw.flush();
		bw.close();
	}
	
	public static void offerQ(int save) {
		if (maxQ.isEmpty()) {
			maxQ.offer(save);
		} else if (maxQ.size()==minQ.size()) {
			if(save>minQ.peek()) {
				maxQ.offer(minQ.poll());
				minQ.offer(save);
			} else {
				maxQ.offer(save);
			}
		} else {
			if (maxQ.peek()>save) {
				minQ.offer(maxQ.poll());
				maxQ.offer(save);	
			} else {
				minQ.offer(save);
			}	
		}
		size++;
	}
	
	public static int pollMin() {
		int result=0;
		while(!tempMinQ.isEmpty()&&tempMinQ.peek()==minQ.peek()) {
			tempMinQ.poll();
			minQ.poll();
		}
		if(!minQ.isEmpty()) {
			tempMinQ.offer(minQ.peek());
			result=minQ.poll();
			size--;
		} else if (!maxQ.isEmpty()) {
			result=maxQ.poll();
			size--;
		}
		System.out.println("**"+tempMinQ.peek());
	return result;	
	}
	
	public static int pollMax() {
		int result=0;
		while(!tempMaxQ.isEmpty()&&tempMaxQ.peek()==maxQ.peek()) {
			tempMaxQ.poll();
			maxQ.poll();
		}
		if (!maxQ.isEmpty()) {
			tempMaxQ.offer(maxQ.peek());
			result=maxQ.poll();
			size--;
		}
		System.out.println("**"+tempMaxQ.peek());
	return result;	
	}
}

