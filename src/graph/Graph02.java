package graph;

import java.util.Arrays;

// 프로그래머스 그래프 레벨3 순위
public class Graph02 {
	public static int solution(int n, int[][] results) {
		int answer = 0;
		
		int INF = 100001;
		int[][] rate = new int[n+1][n+1];		
		for (int[] arr : rate) {
			Arrays.fill(arr, INF); // 알 수없음
		}
		
		for (int[] arr : results) {
			rate[arr[0]][arr[1]] = 1;
		}
		
		for (int k = 1; k < rate.length; k++) {
//			System.out.println("거쳐가는 노드 : " + (k+1));
			for (int i = 1; i < rate.length; i++) {
//				System.out.println((i+1) + "번 노드 출발");
				for (int j = 1; j < rate.length; j++) {
					if(rate[i][j] > rate[i][k] + rate[k][j]) {
						rate[i][j] = rate[i][k] + rate[k][j];
//						System.out.println("rate["+(i+1)+"]["+(k+1)+"] : " + rate[i][k]);	
//						System.out.println("rate["+(k+1)+"]["+(j+1)+"] : " + rate[k][j]);
//						System.out.println("rate["+(i+1)+"]["+(j+1)+"] : " + rate[i][j]);	
//						System.out.println();	
					}
				}
			}
		}
		for (int i = 1; i < rate.length; i++) {
			boolean flag = true;
			for (int j = 1; j < rate.length; j++) {
				if(i == j) continue;
				if(rate[i][j] == INF && rate[j][i] == INF) {
					flag = false;
					break;
				}
			}
			if(flag) answer++;
		}
		for(int[] arr : rate) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		System.out.println(answer);

		return answer;
	}
	public static void main(String[] args) {
		// 테스트 케이스
//		int n = 3;
//		int[][] results = {{2, 3}, {3, 1}, {2, 1}};
		// = 3
		
//		int n = 4;
//		int[][] results = {{1, 3}, {2, 3}, {2, 4}, {4, 1}};
		// = 4
		
		int n = 5;
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		// = 2
		
//		int n = 4;
//		int[][] results = {{2, 1}, {2, 3}, {2, 4}, {4, 1}};
		// = 1

//		int n = 5;
//		int[][] results = {{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}};
		// = 1
		int answer = solution(n, results);
		System.out.println("순위를 매길 수 있는 선수 : " + answer);
	}
}
