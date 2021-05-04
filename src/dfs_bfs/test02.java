package dfs_bfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class test02 {
	public static void bfs(String[][] tickets, Stack<String> route, boolean[] check) {
		int cnt = 0;
		for(boolean b : check) {
			if(b) {
				cnt++;
			}
		}
		
		if(cnt == tickets.length) {
			return;
		}else {
			Map<Integer, String> map = new HashMap<Integer, String>();
			for(int i=0;i<tickets.length;i++) {
				if(check[i] == false && tickets[i][0] == route.peek()) {
					map.put(i, tickets[i][1]);				
				}
			}
			
			int done = 0;
			String str = "";
			for(int i : map.keySet()) {
				if(str == "") {
					done = i;
					str = map.get(i);
				}else if(str.compareTo(map.get(i)) > 0) {
					done = i;
					str = map.get(i);
				}else {
					map.remove(i);
				}
			}
			check[done] = true;
			route.add(str);
			bfs(tickets, route, check);		
		}
	}
    public static String[] solution(String[][] tickets) {
        String[] answer;
        
        Stack<String> route = new Stack<String>();
        boolean[] check = new boolean[tickets.length];
        route.add("ICN");

        bfs(tickets, route, check);
       
        answer = new String[route.size()];
        for(int i=0;i<route.size();i++) {
        	answer[i] = route.get(i);
        }
 
        return answer;
    }
	
	public static void main(String[] args) {
		// 테스트 케이스
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

//		String str1 = "";
//		String str2 = "SFO";
//		System.out.println(str1.compareTo(str2)); // = -10 str2가 str1 보다 작음
		String[] answer = solution(tickets);
		for(String s : answer) {
			System.out.println(s);
		}
	}
}
