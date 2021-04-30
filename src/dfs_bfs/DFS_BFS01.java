package dfs_bfs;

// 프로그래머스 DFS/BFS 레벨2 타겟 넘버
public class DFS_BFS01 {
    public static int sign(int i) {
        return i == 1 ? 1 : -1;
    }
    
    static int solution(int[] numbers, int target) {
        int answer = 0;     
        
        int max = 1;        
        for(int i = 0 ; i < numbers.length; i++) {
            max*=2;
        }       
        
        int cur = 0;        
        while(cur < max) {
            int val = 0;
            for(int i = 0 ; i < numbers.length ; i++) {
                int temp = cur;
                val += sign((temp >> i) & 1) * numbers[i];
            }

            if(val == target) {
                answer++;
            }
            cur++;
        }        

        return answer;
    }
    
	public static void main(String[] args) {
		// 테스트 케이스
		int[] numbers = {1, 2, 3, 4, 5};
		int target = 5;
		
		int answer = solution(numbers, target);
		System.out.println("경우의 수 : " + answer);
	}
}
