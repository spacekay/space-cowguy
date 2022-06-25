class Solution {
    public int solution(String s) {
      
      // 초기 버전 기록용으로 업로드
      // 예제 5개는 해결되나 반례가 존재함을 확인
      
        int L = s.length();
        int l = s.length()/2;
        int answer = 1001;
        for(int i=1;i<=l;i++) {
            String start = s.substring(0,i);
            int count = 1;
            String checker = "";
            boolean flag = false;
            for(int j=i;j<L;j=j+i) {
                String now;
                try {
                    now = s.substring(j,j+i);
                } catch (Exception e) {
                    checker += start;
                    checker += s.substring(j,L);
                    flag = true;
                    break;
                }
                
                if(now.equals(start)) {
                    count++;
                } else if (count>1) {
                    checker += Integer.toString(count);
                    checker += start;
                    start = now;
                    count = 1;
                } else {
                    checker += start;
                    start = now;
                    count = 1;
                }
            }
            if (count>1) {
                checker += Integer.toString(count);
                checker += start;
            } else if (!flag) {
                checker += start;
            }
            answer = Math.min(answer, checker.length());       
        }            
        return answer;
    }
}
