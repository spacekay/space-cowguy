class Solution {
    public int solution(String s) {
        
        // 주요 수정 사항은, last 변수의 설정이다.
        
        int L = s.length();
        int l = s.length()/2;
        int answer = 1001;
        
        // 문자 1개짜리 문자열이 들어와도 처리할 수 있어야 함
        if(L==1) {
            answer = 1;
        } else {
            for(int i=1;i<=l;i++) {
                String start = s.substring(0,i);
                int count = 1;
                String checker = "";
                // 바깥 for문에서 선언
                String last = "";

                for(int j=i;j<L;j+=i) {
                    // 안정적인 if문으로 설정
                    if(j+i>L) {
                        last = s.substring(j, L);
                        continue;
                    }
                    
                    String now = s.substring(j,j+i);
                    if(start.equals(now)) {
                        count++;
                    } else {

                        if(count>1) {
                            checker += count;
                        }

                        checker += start;
                        start = now;
                        count = 1;
                    } 
                }

                if(count>1) {
                    checker += count;
                    checker += start;
                } else {
                    checker += start;
                }
                
                // 꼬리 문자열이 있는 경우에만 붙이도록 함
                checker += last;

                answer = Math.min(answer, checker.length());       
            } 
        }        
        return answer;
    }
}
