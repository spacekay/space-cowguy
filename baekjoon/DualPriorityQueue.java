import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class DualPriorityQueue {
	static PriorityQueue<Integer> minQ;
	static PriorityQueue<Integer> maxQ;
	static TreeMap<Integer,Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		String[] save;
		// 자바는 뭘 해도 느리다고 생각하자. 가장 간단하게 할 수 있는 방법을 이 느린 언어로 잘 찾아보자.
		// Map을 활용하여 일반적인 풀이를 하였다.
		// 다른 사람 답들을 보니 별도 Class를 만들어서 푼 경우도 많다. 연구하여 추가 업데이트 예정이다.
		for(int i=0;i<T;i++) {
			minQ = new PriorityQueue<>();
			maxQ = new PriorityQueue<>(Comparator.reverseOrder());
			map = new TreeMap<>();
			int k=Integer.parseInt(br.readLine()); 
			for(int j=0;j<k;j++) {
				save=br.readLine().split(" ");
				int n=Integer.parseInt(save[1]);
				switch(save[0].charAt(0)) {	
				case 'I':				
					offerQ(n);
					break;
				case 'D':
					if(map.isEmpty()) {
						continue;
					} else if(n==1) {
						pollMax();
					} else if (n==-1) {
						pollMin();
					}
					break;
				}
			}
			if(map.size()==0) {
				bw.write("EMPTY\n");
			} else {
				bw.write(map.lastKey()+" "+map.firstKey()+"\n");
			}
		}
		br.close();	
		bw.flush();
		bw.close();
	}

	public static void offerQ(int save) {
		maxQ.offer(save);
		minQ.offer(save);
		map.put(save, map.getOrDefault(save, 0)+1);
	}

	public static int pollMin() {
		int result=map.firstKey();
		int save=map.get(result);
		if(save>1) {
			map.put(result, save-1);
		} else {
			map.pollFirstEntry();
		}
		return result;	
	}

	public static int pollMax(){
		int result=map.lastKey();
		int save=map.get(result);
		if(save>1) {
			map.put(result, save-1);
		} else {
			map.pollLastEntry();
		}
		return result;	
	}
}
