package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 프로그래머스 그래프 레벨3 가장 먼 노드
public class Graph01 {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        boolean[][] connect = new boolean[n][n];

        for(int i=0; i<edge.length; i++){
            connect[edge[i][0]-1][edge[i][1]-1]=true;
            connect[edge[i][1]-1][edge[i][0]-1]=true;
        }
        
        boolean[] check = new boolean[n];       
        check[0]=true;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);

        while(!que.isEmpty()){
            int qSize = que.size();
            for(int i=0; i<qSize;i++){
                int node = que.poll();
                for(int j=0; j<n; j++){
                    if(connect[j][node]&&!check[j]){
                        check[j]=true;
                        que.add(j);
                    }
                }
            }
            answer=qSize;
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// 테스트 케이스
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		int answer = solution(n, edge);
		
		System.out.println("가장 먼 노드 수 : " + answer);
	}
}
