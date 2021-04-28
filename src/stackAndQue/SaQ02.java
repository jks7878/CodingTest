package stackAndQue;

// 프로그래머스 스택/큐 레벨2 주식가격
public class SaQ02 {
	static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		// 이중 for문 이용 풀이
		for(int i=0;i<answer.length;i++) {
			for (int j=i;j<answer.length;j++) {
				if(prices[i] > prices[j]) {
					answer[i] = j-i;
					break;
				}
				answer[i] = j-i;
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// 테스트 케이스
		int[] prices = {1,2,3,2,3,1}; // = {4,3,1,1,0}
		
		int[] answer = solution(prices);
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
