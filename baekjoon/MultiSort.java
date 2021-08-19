import java.io.*;
import java.util.*;

public class MultiSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		LinkedList<ArrayList<Integer>> x = new LinkedList<ArrayList<Integer>>();
  
    // 정렬 방식에 따른 시간복잡도를 체감한 문제
    // 데이터를 읽고 쓰고 지우는 연산을 최소화할 수 있도록 고민
		for (int i = 0 ; i < n ; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			list.add(Integer.parseInt(st.nextToken()));
			list.add(Integer.parseInt(st.nextToken()));
			x.add(list);
		}
    
    // 원소를 리스트로 가지는 리스트는 Comparator가 정의되지 않았으므로
    // main method 안에서 그냥 새로운 개체 선언하여 compare method override하여야 sort method 작동
		Collections.sort(x, new Comparator<ArrayList<Integer>>() {
      @ Override
			public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
				if (list1.get(0) > list2.get(0)) {
					return 1;
				} else if (list1.get(0) < list2.get(0)) {
					return -1;
				} else {
					if (list1.get(1) > list2.get(1)) {
						return 1;
					} else if (list1.get(1) < list2.get(1)) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});

		while (true) {
			try {			
				sb.append(x.get(0).get(0)+" "+x.get(0).get(1)+"\n");			
				x.remove(0);
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(sb.toString());
		br.close();
	}
}
