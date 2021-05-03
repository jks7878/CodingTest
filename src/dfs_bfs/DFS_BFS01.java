package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스 DFS/BFS 레벨2 타겟 넘버
public class DFS_BFS01 {
    static List<Integer> list = new ArrayList<Integer>();
    public static int sign(int i) {
        return i == 1 ? 1 : -1;
    }
    public static int bfs(int[] numbers, int target, int sum, int i) {
    	System.out.println(sum);
        if(i == numbers.length) {
            if(sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int result = 0;

        result += bfs(numbers, target, sum+numbers[i], i+1);
        result += bfs(numbers, target, sum-numbers[i], i+1);

        return result;
    }
    static int solution(int[] numbers, int target) {
        int answer = 0;     

        answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);

//        while(cur < 10) {
//        	sum = 0;
//        	cur++;      	
//        }
   
//        int max = 1;        
//        for(int i = 0 ; i < numbers.length; i++) {
//            max*=2;
//        }       
//        
//        int cur = 0;        
//        while(cur < max) {
//            int val = 0;
//            for(int i = 0 ; i < numbers.length ; i++) {
//                int temp = cur;
//                val += sign((temp >> i) & 1) * numbers[i];
//            }
//
//            if(val == target) {
//                answer++;
//            }
//            cur++;
//        }        

        return answer;
    }
    
	public static void main(String[] args) {
		// 테스트 케이스
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		
		int answer = solution(numbers, target);
		System.out.println("경우의 수 : " + answer);
	}
}
