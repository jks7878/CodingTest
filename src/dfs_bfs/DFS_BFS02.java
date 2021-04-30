package dfs_bfs;

// 프로그래머스 DFS/BFS 레벨3 네트워크
public class DFS_BFS02 {
	static void dfs(int node, int[][] computers, boolean[] check) {
		check[node] = true;

		for(int i=0;i<computers.length;i++) {
			System.out.println("computers[" + node + "]" + "[" + i + "]");
			if(check[i] == false && computers[node][i] == 1) {
				dfs(i, computers, check);
			}
		}
	}
    static int solution(int n, int[][] computers) {
        int answer = 0;
  
        boolean[] check = new boolean[n];
        
		for (int i=0;i<computers.length;i++) {
			if(check[i] == false) {
				answer++;
				dfs(i, computers, check);
			}
		}       

        return answer;
    }
	public static void main(String[] args) {
		// 테스트 케이스
//		int n = 3;
//		int[][] computers = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		// = 3
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 1, 1}};
		// = 2		
//		int n = 6;
//		int[][] computers =  {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, 
//				{0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};
		// = 1
//		int n = 4;
//		int[][] computers = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 1, 0, 1}};	
		// = 1

		
		int answer = solution(n, computers);
		System.out.println(answer);
	}
}
