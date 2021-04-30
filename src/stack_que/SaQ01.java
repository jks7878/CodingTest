package stack_que;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 프로그래머스 스택/큐 레벨2 다리를 지나는 트럭
public class SaQ01 {
	static void check(Queue<Integer> crossing, int i, int nowWeight, int weight, int[] truck_weights) {
		
	}
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; // 걸린 시간을 담을 값 

        Queue<Integer> crossing = new LinkedList<Integer>(); // 다리를 지는 도중인 트럭들을 담아두는 용도로 사용
       	List<Integer> crossed = new ArrayList<Integer>(); // 다리를 전부 지난 트럭들을 담아두는 용도로 사용
        
       	int i = 0; // 각 트럭의 인덱스값
        int nowWeight = 0; // 다리를 지나는 도중인 트럭들의 무게 총합
        while(true) { 
        	if(crossing.size() >= bridge_length) { // crossing 큐의 값이 다리 길이보다 커지는 경우 == 트럭 하나가 다리를 전부 지난 상황
        		if(crossing.peek() != 0) { // 값이 0이 아닐 경우 == 트럭일 경우 지난 트럭에 add
                	crossed.add(crossing.peek()); // poll 할 경우 값을 제거하기 때문에 peek으로 조회
                	nowWeight -= crossing.poll(); // 지난 트럭의 무게를 다리 위으 트럭 무게 총합에서 뺀다 
        		}else {
        			crossing.remove(); // 값이 0인 경우 지난 트럭에 add 하지 않고 삭제한다
        		}	
            	System.out.println("crossed Trucks : " + crossed.size());
        	}    
        	
        	if(i < truck_weights.length && weight >= nowWeight + truck_weights[i]) {
        	// trcuk_weiths.length 보다 작은 값으로 조건을 걸어두지 않으면 ArrayIndexOutOfBoundsException 발생
        		crossing.add(truck_weights[i]); 
        		nowWeight += truck_weights[i];	
        		// 총 하중이 다리의 하중을 넘지 않을 때까지 crossing으로 add
        		i++;
        		// 트럭의 인덱스값 증가
        	}else {
        		crossing.add(0);
        		// 총 하중이 다리의 하중을 넘을 경우 무게는 +하지 않고 확인만을 위한 용도인 값 0을 추가
        	}	
       	
    		System.out.println(crossing);
    		System.out.println("nowWeight : " + nowWeight);
        	answer++; // 모든 행동이 끝날 때마다 시간초++;
        	System.out.println("sec : " + answer);
        	
        	if(crossed.size() == truck_weights.length) { // 건넌 트럭 수가 트럭들의 무게를 담은 배열의 길이와 같아질 경우 while문 break
        		break;
        	}   
        }
        
        return answer;
    }
	public static void main(String[] args) {
		// 테스트 케이스
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7, 4, 5, 6};
		// = 8
		
//		int bridge_length = 5;
//		int weight = 5;
//		int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
		// = 19
		
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		// = 110
		
		int sec = solution(bridge_length, weight, truck_weights);
		System.out.println("시간(초) : " + sec);
	}
}
