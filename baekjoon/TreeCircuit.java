import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeCircuit {
	static int n;
	static Node[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		boolean[] check = new boolean[n];
		arr = new Node[n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = st.nextToken().charAt(0)-'A';
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			arr[a] = new Node();
			if(b!='.') {
				arr[a].left=b-'A';
			}
			if(c!='.') {
				arr[a].right=c-'A';
			}
		}
		Front(0, check);
		bw.write("\n");
		Arrays.fill(check, false);
		Mid(0, check);
		bw.write("\n");
		Arrays.fill(check, false);
		Rear(0, check);
		bw.write("\n");
		bw.flush();
		bw.close();
	}
	public static void Front(int n, boolean[] check) throws IOException {
		if(check[n])
			return;
		check[n]=true;
		// 먼저 가는 쪽부터 루트부터 바로 씀
		char c = (char) (n+'A');
		bw.write(c);
		if(arr[n].left!=-1) {
			Front(arr[n].left, check);
		}
		if(arr[n].right!=-1) {
			Front(arr[n].right, check);
		}
	}
	public static void Mid(int n, boolean[] check) throws IOException {
		if(check[n])
			return;
		check[n]=true;
		if(arr[n].left!=-1) {
			Mid(arr[n].left, check);
		}
		// 왼쪽으로 쭉 가고 나서 오른쪽 가기 전에 루트 씀
		char c = (char) (n+'A');
		bw.write(c);
		if(arr[n].right!=-1) {
			Mid(arr[n].right, check);
		}
	}
	public static void Rear(int n, boolean[] check) throws IOException {
		if(check[n])
			return;
		check[n]=true;
		if(arr[n].left!=-1) {
			Rear(arr[n].left, check);
		}
		if(arr[n].right!=-1) {
			Rear(arr[n].right, check);
		}
		// 자식 레벨에서부터 올라오면서 써내려감 (왼->오->루트)
		char c = (char) (n+'A');
		bw.write(c);
	}
	static class Node {
		int left;
		int right;
		public Node() {
			left=-1;
			right=-1;
		}
	}
}
