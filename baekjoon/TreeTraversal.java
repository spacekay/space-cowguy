import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal {
	static int[] in;
	static int[] post;
	static int[] index;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		in = new int[n+1];
		post = new int[n+1];
		index = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");		
		for(int i=1;i<=n;i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		br.close();		
		for(int i=1;i<=n;i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			index[in[i]] = i;
		}
		
		preOrder(1, n, 1, n);
		sb.append("\n");
		System.out.println(sb.toString());
	}
	// Parameter는 모두 각 배열의 인덱스
	static void preOrder(int inStart, int inEnd, int postStart, int postEnd){
		
		if(inStart>inEnd || postStart>postEnd)
			return;
		
		int root = post[postEnd];
		sb.append(root).append(" ");
		// index[root] -> pre array에서 현재 root의 위치
		
		// 왼 -> 루트 (inOrder 순서)
		// index[root]-inStart는 해당 부분 트리의 원소 개수
		// 왼쪽 트리 왼쪽 끝, 왼쪽 트리 루트, 왼쪽 트리 왼쪽 끝, 왼쪽 트리 루트
		preOrder(inStart, index[root], postStart, postStart+index[root]-inStart-1);
		
		// 루트 -> 오 (inOrder 순서)
		//postStart+index[root]는 루트 기준 오른쪽 트리의 가장 왼쪽 노드
		// 오른쪽 트리 루트, 오른쪽 트리 오른쪽 끝, 오른쪽 트리 오른쪽 끝, 오른쪽 트리 루트
		preOrder(index[root]+1, inEnd, postStart+index[root]-inStart, postEnd-1);	
	}
}
