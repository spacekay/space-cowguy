import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Numbering2dBFS {
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
		int t=1;
		for (int i = 0 ; i < n ; i++) {
			for(int j=0; j<n;j++) {
				if(!conn[i][j].isFlag() && conn[i][j].getT()!=0) {
					conn=BFS(conn,j,i,t);
				}
			}
		}
		bw.write(cnt+"\n");
    // 문제 출력 조건이 오름차순이었음. 이걸 확인했어야 함
		Collections.sort(list);
		for(Integer one : list) {
			bw.write(one+"\n");
		}
		bw.flush();
		bw.close();
	}

  // 아래 코드는 주변 포인트들과의 결과 확인 후 set 함수 구동하는 부분을 함수로 만들어주면 텍스트량이 확 줄어들 것
  // t 같은 경우에도 생략하고 1로 처리해도 될듯
	private static Point[][] BFS(Point[][] conn, int x, int y, int t) {
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
			int pointT=v.getT();
			if (pointX<conn.length-1) {
				if (v.checkConnect(conn[pointY][pointX+1])&&!conn[pointY][pointX+1].isFlag()) {
					conn[pointY][pointX+1].setT(pointT);
					conn[pointY][pointX+1].setFlag(true);
					bfs.offer(conn[pointY][pointX+1]);
				}
			}
			if (pointX>0) {
				if (v.checkConnect(conn[pointY][pointX-1])&&!conn[pointY][pointX-1].isFlag()) {
					conn[pointY][pointX-1].setT(pointT);
					conn[pointY][pointX-1].setFlag(true);
					bfs.offer(conn[pointY][pointX-1]);
				}
			}
			if (pointY<conn.length-1) {
				if (v.checkConnect(conn[pointY+1][pointX])&&!conn[pointY+1][pointX].isFlag()) {
					conn[pointY+1][pointX].setT(pointT);
					conn[pointY+1][pointX].setFlag(true);
					bfs.offer(conn[pointY+1][pointX]);
				}
			}
			if (pointY>0) {
				if (v.checkConnect(conn[pointY-1][pointX])&&!conn[pointY-1][pointX].isFlag()) {
					conn[pointY-1][pointX].setT(pointT);
					conn[pointY-1][pointX].setFlag(true);
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
