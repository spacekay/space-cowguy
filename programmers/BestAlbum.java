import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
      int n=plays.length;    
		LinkedHashMap<String,Integer> sum = new LinkedHashMap<>();
		LinkedHashMap<String,ArrayList<Integer>> song = new LinkedHashMap<>();
		for(int i=0;i<n;i++) {
			sum.put(genres[i], sum.getOrDefault(genres[i], 0)+plays[i]);
			ArrayList<Integer> list;
			if(song.containsKey(genres[i])) {
				list=song.get(genres[i]);
				list.add(i);
				song.put(genres[i], list);
			} else {
				list=new ArrayList<>();
				list.add(i);
				song.put(genres[i], list);
			}
		}
		ArrayList<String> post = new ArrayList<>(sum.keySet());
		Collections.sort(post, new Comparator<String>() {
			public int compare(String o1, String o2) {
        // 다른 객체의 성분을 이용해 compare 하는 것도 가능
				return sum.get(o2).compareTo(sum.get(o1));
			}
		});
		n=post.size();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0;i<n;i++) {
			ArrayList<Integer> list = song.get(post.get(i));
			if(list.size()==1) {
				ans.add(list.get(0));
			} else {
				Collections.sort(list, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						if(plays[o1]==plays[o2]) {
							return o1.compareTo(o2);
						} else {
							return plays[o2]-plays[o1];
						}
					}	
				});
				ans.add(list.get(0));
				ans.add(list.get(1));
			}
		}
		n=ans.size();
		int[] answer=new int[n];
		for(int i=0;i<n;i++) {
			answer[i]=ans.get(i);
		}
		return answer;
    }
}
