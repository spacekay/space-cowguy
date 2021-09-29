import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
     	int t = 0;
		boolean flag = false;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int l=scoville.length;
		for(int i=0;i<l;i++) {
			q.offer(scoville[i]);
		}
		while(t<l) {
			int first;
			int second;
			int num=0;
			try {
				first = q.poll();
				second = q.poll();
			t++;
			num=first+second*2;
        // 예외가 발생할 수 있는 구문은 항상 체크
			if(num>=K && q.peek()>=K) {
				flag=true;
				break;
			} else {
				q.offer(num);
			}
			} catch (Exception e) {
        // Flag 설정에 유의
				if(num>=K)
					flag=true;
				break;
			}
		}
		if (!flag) {
			t=-1;
		}
		return t;
    }
}
