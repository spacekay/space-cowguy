import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static int cnt=0;
	static ArrayList<Integer> list=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		Point[][] conn = new Point[n][n];
		String line;
		for (int i = 0 ; i < n ; i++) {
			line=br.readLine();
			for(int j=0; j<n;j++) {
				if(line.charAt(j)=='1') {
					conn[i][j]=new Point(j,i,1);
				} else {
					conn[i][j]=new Point(j,i,0);
				}
			}
		}
		br.close();
		for (int i = 0 ; i < n ; i++) {
			for(int j=0; j<n;j++) {
				if(!conn[i][j].isFlag() && conn[i][j].getT()!=0) {
					conn=BFS(conn,j,i);
				}
			}
		}
		bw.write(cnt+"\n");
		// 문제의 조건을 잘 살펴야 함!
		Collections.sort(list);
		for(Integer one : list) {
			bw.write(one+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static Point[][] BFS(Point[][] conn, int x, int y) {
		int t=1;
		cnt++;
		int localCnt=0;
		Queue<Point> bfs = new LinkedList<>();
		conn[y][x].setT(t);
		conn[y][x].setFlag(true);
		bfs.add(conn[y][x]);
		while (!bfs.isEmpty()) {
			Point v = bfs.poll();
			localCnt++;
			int pointX=v.getX();
			int pointY=v.getY();
			//conn array의 원본의 Point 객체가 직접 수정되어야 하므로 코드를 간략하게 만드는 데에 내 현재 역량으로는 한계가 있음
			//그래도 알고리즘 자체는 이해하는 데에 큰 도움이 되었음
			if (pointX<conn.length-1) {
				if (v.checkConnect(conn[pointY][pointX+1])&&!conn[pointY][pointX+1].isFlag()) {
					conn=v.setPoints(conn, pointX+1, pointY);
					bfs.offer(conn[pointY][pointX+1]);
				}
			}
			if (pointX>0) {
				if (v.checkConnect(conn[pointY][pointX-1])&&!conn[pointY][pointX-1].isFlag()) {
					conn=v.setPoints(conn, pointX-1, pointY);
					bfs.offer(conn[pointY][pointX-1]);
				}
			}
			if (pointY<conn.length-1) {
				if (v.checkConnect(conn[pointY+1][pointX])&&!conn[pointY+1][pointX].isFlag()) {
					conn=v.setPoints(conn, pointX, pointY+1);
					bfs.offer(conn[pointY+1][pointX]);
				}
			}
			if (pointY>0) {
				if (v.checkConnect(conn[pointY-1][pointX])&&!conn[pointY-1][pointX].isFlag()) {
					conn=v.setPoints(conn, pointX, pointY-1);
					bfs.offer(conn[pointY-1][pointX]);
				}
			}
		}
		list.add(localCnt);
		return conn;
	}
}

class Point {
	private int x;
	private int y;
	private int t;
	private boolean flag=false;
	public Point (int x, int y, int t) {
		this.setX(x);
		this.setY(y);
		this.setT(t);
	}
	public boolean checkConnect(Point p) {
		if (this.t!=p.t) {
			return false;
		} else {
			return true;
		}
	}
	public Point[][] setPoints(Point[][] conn, int x, int y) {
			conn[y][x].setT(this.t);
			conn[y][x].setFlag(true);
		return conn;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
