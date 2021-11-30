import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearchTree {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String now;
		Tree tree = new Tree();
		while((now = br.readLine()) != "" && now != null) {
			int n = Integer.parseInt(now);
			tree.addData(n);
		}
		br.close();
		tree.printPost();
		bw.flush();
		bw.close();
	}
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int n) {
			this.data = n;
		}
	}
	// Tree class 직접 구현해보기!
	static class Tree {
		Node root;
		
		public void addData(int n) {
			if(root==null) {
				root = new Node(n);
				return;
			}			
			addData(root, n);
		}
		
		private void addData(Node node, int n) {
			// 더 이상 갈 길이 없으면 멈춘다.
			if(node==null)
				return;
			if(node.data>n) {
				if(node.left==null) {
					node.left = new Node(n);
					return;
				} else {
					addData(node.left, n);
				}
			} else {
				if(node.right==null) {
					node.right = new Node(n);
				} else {
					addData(node.right, n);
				}
			}
		}
		
		public void printPost() throws IOException {
			printPost(root);
		}
		
		private void printPost(Node node) throws IOException {
			// 더이상 갈 길이 없으면 멈춘다. (재귀 무한 실행을 막기 위해 필수)
			if(node==null)
				return;
			printPost(node.left);
			printPost(node.right);
			// 후위 탐색은 맨 뒤에서 써준다. (왼 - 오 - 루트)
			bw.write(node.data+"\n");
		}		
	}
}
