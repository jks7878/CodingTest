package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_BFS04 {
	public static String bfs(String location, String[][] tickets, boolean[] check) {
//		bfs(String location, String[][] tickets, boolean[] check, int cnt)
//		if(cnt == tickets.length + 1) {
//			return location;
//		}
		
		int tmp = 0;
		for(int i=0;i<tickets.length;i++) {
			if(check[i] == false && tickets[i][0] == location) {
				if(tmp != 0) {
					if(tickets[tmp][1].compareTo(tickets[i][1]) > 0) {
						check[tmp] = false;
						tmp = i;
						check[i] = true;
					}
				}else {
					tmp = i;	
					check[i] = true;
				}
			}
		}
		
//		return bfs(tickets[tmp][1], tickets, check, ++cnt);
		return tickets[tmp][1];
	}
    public static String[] solution(String[][] tickets) {
        String[] answer;
        
        List<String> route = new ArrayList<String>();
        boolean[] check = new boolean[tickets.length];
        
        route.add("ICN");
        String str = "ICN";
        for(int i=0;i<tickets.length;i++) {
        	str = bfs(str, tickets, check);
        	route.add(str);
        }

        System.out.println(route);
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

		String[] answer = solution(tickets);
		for(String s : answer) {
			System.out.println(s);
		}
	}
}
