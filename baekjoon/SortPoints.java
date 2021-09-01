import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SortPoints {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;		
		int x;
		int y;
		// 큰 수의 정렬을 위해서는 무작정 이차원 배열 만들고 시작하면 안된다.
		ArrayList<Integer> list;
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		for (int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			if (!map.containsKey(y)) {
        // 없을 때는 새로 만들어주기만 하고 바로 넣기
				list = new ArrayList<Integer>();
				list.add(x);
			} else {
        // 이미 원소 있을 때만 리스트에 성분 넣어주고 정렬 미리 해주기
				list = map.get(y);
				list.add(x);
				Collections.sort(list);
			}
			map.put(y, list);
		}
		StringBuilder sb = new StringBuilder();
		while (!map.isEmpty()) {
			y = map.firstKey();
			list = map.get(y);
			for (int i = 0; i<list.size(); i++) {
				x=list.get(i);
				sb.append(x).append(" ");
				sb.append(y).append("\n");
			}
			map.remove(y);
		}
		System.out.println(sb.toString());
		br.close();
	}
}
