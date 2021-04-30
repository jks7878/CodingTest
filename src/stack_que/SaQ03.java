package stack_que;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SaQ03 {
    static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        int order = 0; // 진행 순서를 확인하기 위한 변수
        while(order != progresses.length) { // order가 progresses의 length와 같아지면 모든 작업이 완료된 것으로 간주하고 while문 종료
        	// progresses의 각 작업마다 speeds 만큼 +
        	for(int i=0;i<progresses.length;i++) {
        		if(progresses[i] < 100) {
        			progresses[i] += speeds[i];
        		}
        	}     	
        	
        	// 진행도가 100%인 것들 중 order와 일치하는 것들을 순서대로 스택에 추가
        	for(int i=0;i<progresses.length;i++) {
        		if(progresses[i] >= 100 && i == order) {
        			stack.push(i);
        			order++; // 추가할 때마다 order++
        		}
        	}
        	
        	// stack의 사이즈가 0이 아닐 경우 스택의 사이즈 만큼 answer list에 추가
        	if(stack.size() != 0) {
            	System.out.println(stack);
        		System.out.println("size : " + stack.size());
        		answer.add(stack.size());
        		stack.clear(); // stack을 초기화
        	}
        }        

        return answer.stream().mapToInt(i->i).toArray(); // stream을 통해 int 배열로 변환시켜 return
    }
	public static void main(String[] args) {
		// 테스트 케이스
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		// = {2,1}
//		int[] progresses = {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
		// = {1, 3, 2}
		
		int[] answer = solution(progresses, speeds);
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
