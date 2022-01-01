import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class  NewRecruits {
	
	// ArrayList<Newbie> >>> Newbie[n] >= int[n][2]  (정렬 속도 비교)
	// Arrays.sort보다 Collections.sort가 더 나은듯
	static ArrayList<Newbie> nb;
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int l = 0;l<T;l++) {
			int n = Integer.parseInt(br.readLine());
			nb = new ArrayList<>();
			for(int j=0;j<n;j++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				nb.add(new Newbie(x,y));
			}
			
			// paper만 고려하여 정렬한다는 뜻
			Collections.sort(nb, Comparator.comparingInt(o1->o1.paper));
			
			int interview = nb.get(0).interview;
			// nb(0)의 아래에 있는 모든 원소들은 서류 점수가 nb(0)보다 낮은 것이다.
			// 면접 점수마저 낮다면 합격 가능성이 바로 사라진다.
			// 이와 비슷한 절차를 계속한다. nb(i) 아래 있는 모든 원소들은 면접 점수가 nb(i)보단 높아야 한다.
			int t = n;
			for(int i=0;i<n;i++) {
				if(nb.get(i).interview>interview) {
					t--;
				} else if(nb.get(i).interview <interview) {
					interview = nb.get(i).interview;
				}
			}	
			bw.write(t+"\n");
		}		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class Newbie {
		int paper;
		int interview;
		
		public Newbie(int x, int y) {
			paper = x;
			interview = y;
		}
	}
}
