package graph0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 미완성
public class TreeCircuit {
	static int n;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		boolean[] check = new boolean[n];
		arr = new Node[n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			String a = st.nextToken();
			String b = st.nextToken();
			String c = st.nextToken();
			arr[a.charAt(0)-'A'] = new Node(a,b,c);
		}
		check[0]=true;
		Front("A", check);
		sb.append("\n");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		Rear("A", check);
		System.out.println(sb.toString());
		bw.flush();
		bw.close();
	}
	public static void Front(String s, boolean[] check) {
		sb.append(s);
		System.out.println(s);
		int k = s.charAt(0)-'A';
		Node node = arr[k];
		if(!node.left.equals(".")) {
			int i=node.left.charAt(0)-'A';
			if(!check[i]) {
				check[i]=true;
				System.out.println("l");
				Front(node.left, check);		
			}	
		}
		if(!node.right.equals(".")) {
			int i=node.right.charAt(0)-'A';
			if(!check[i]) {
				check[i]=true;
				System.out.println("r");
				Front(node.right, check);		
			}
		}
	}
	public static void Rear(String s, boolean[] check) {
		int k = s.charAt(0)-'A';
		Node node = arr[k];
		if(!node.left.equals(".")) {
			int i=node.left.charAt(0)-'A';
			if(!check[i]) {
				check[i]=true;
				System.out.println("l");
				Front(node.left, check);		
			}	
		}
		if(!node.right.equals(".")) {
			int i=node.right.charAt(0)-'A';
			if(!check[i]) {
				check[i]=true;
				System.out.println("r");
				Front(node.right, check);		
			}
		}
		sb.append(s);
		System.out.println(s);
	}
	
	
	static class Node {
		String self;
		String left;
		String right;

		public Node(String a, String b, String c) {
			self=a;
			left=b;
			right=c;
		}
	}
}
