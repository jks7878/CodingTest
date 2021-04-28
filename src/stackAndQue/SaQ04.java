package stackAndQue;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 스택/큐 레벨2 프린터
public class SaQ04 {
    static int solution(int[] priorities, int location) {
        int answer = 0;
        int req = location+1; // 원하는 인쇄물의 index값 + 1(= n번째)
        System.out.println("first req : " + req + "번째로 인쇄");
    	

        // priorities 배열의 값들을 Queue 클래스에 순서대로 add
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities) {
        	que.add(i);
        }
        System.out.println("first list : " + que);
        int tmp; // 큐의 값들을 비교하기 위해 가장 처음 값을 저장한 변수 선언
        while(true) {
            boolean end = true; // 종료지점을 확인하기 위한 boolean 변수
            tmp = que.peek();
            for(Object i : que.toArray()) {
            	if((int) i > tmp) {
            		que.poll(); // 가장 앞의 값을 빼서
            		que.add(tmp); // 가장 뒤에 넣는다
            		if(req == 1) {
            			req = que.size(); // 첫번째 순서였을 경우 가장 뒤로 밀려나기 때문에 size만큼으로 순서 변경
            		}else {
                		req--; // 그 외의 경우에는 1씩 줄어듦
            		}
            		System.out.println("req list : " + que);
            		System.out.println("now req : " + req + "번째로 인쇄");
            		end = false; // 큐에 변동이 일어났다면 end 값을 false로 바꾼 뒤 다시 반복
            		break;
            	}
            }
            // 큐에 변동이 없을 경우 
            if(que.size() != 0 && end == true) {
            	// 앞에서부터 차례대로 값을 poll하면서 req값을 1씩 줄이고 반대로 answer값은 1씩 늘린다
            	que.poll(); 
            	req--;
            	answer++; 
            	// req가 0에 도달했을 경우 answer 값은 원래 목표했던 값의 index에 도달하기 때문에 break
            	if(req == 0) {
            		break;
            	}
            	System.out.println("req list : " + que);
            	System.out.println("now req : " + answer + "번째로 인쇄");
            }
        }

        return answer;
    }
	public static void main(String[] args) {
		// 테스트 케이스
//		int[] priorities = {2, 1, 3, 2}; 	
//		int location = 2;
		// = 1
//		int[] priorities = {1, 1, 9, 1, 1, 1};
//		int location = 0;
		// = 5
		int[] priorities = {4, 5, 3, 2, 1, 1};
		int location = 0;
		// = 2
		int answer = solution(priorities, location);
		System.out.println(answer + "번째로 인쇄");
	}
}
