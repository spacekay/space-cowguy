class Solution {   

    static int min = 100;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] checked = new boolean[words.length];

        DFS(checked, words, target, begin, 0);

        if(min<100)
            answer = min;
        return answer;
    }

    static void DFS(boolean[] checked, String[] words, String target, String now, int level) {        
        if(now.equals(target)) {
            min = Math.min(min, level);
            return;
        } else if(!isCheckedAll(checked)) {
            for(int i=0;i<checked.length;i++) {
                if(!checked[i] && isCorrect(now, words[i])) {
                    checked[i] = true;
                    DFS(checked, words, target, words[i], level+1);
                    checked[i] = false;
                }
            }           
        } else {
            return;
        }        
    }

    static boolean isCheckedAll(boolean[] checked) {
        for(boolean one:checked) {
            if(!one)
                return false;
        }
        return true;
    }

    static boolean isCorrect(String target, String now) {
        int t = 0;
        for(int i=0;i<target.length();i++) {
            if(target.charAt(i)!=now.charAt(i)) {
                t++;
            }
            if(t>1)
                return false;           
        }

        if(t==0)
            return false;
        else {
            return true;
        }            
    }
}
