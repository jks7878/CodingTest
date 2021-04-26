package search;

// 프로그래머스 완전탐색 레벨2 카펫
public class Search03 {
	public static int[] solution(int brown, int yellow) {	
		int[] answer = new int[2];		
		int sum = brown + yellow; // 사각형의 가로x세로는 갈색 격자와 노란 격자의 총합과 같아야됨

		for(int i=3;i<brown/2;i++) { // 가로 길이
			for(int j=3;i*j<=sum;j++) { // 세로 길이
			// 갈색 격자의 최소값이 8, 노란 격자의 최소값이 1이기 때문에 최소값인 3x3부터 검색하기 위해 초기값을 3으로 설정
				if(sum == i*j && brown > i*2 && i >= j && (i-2)*(j-2) == yellow) {
				// 조건 1: 가로x세로의 값이 전체 크기와 같으면서,
				// 조건 2: 가로x2가 갈색 타일의 개수를 넘지 않으면서(만약 한변의 두배가 갈색 타일의 최대값을 넘어버리면 모든 면을 채울 수 없음),
				// 조건 3: 세로가 가로보다 크거나 작으면서,
				// 조건 4: 가로-2 x 세로-2의 값이 노란 격자의 총합과 같은 것을 정답 배열에 담는다
					answer[0] = i;
					answer[1] = j;
				}
			}
		}
		
		return answer; 
	}
	public static void main(String[] args) {
		// 테스트 케이스
		int brown = 8;
		int yellow = 1;
		
		int[] answer = solution(brown, yellow);
		
		// 문제에는 없지만 어떤 모양인지 궁금해서 만들어본 카펫 프린트문
		int row = answer[0];
		int col = answer[1];

		for(int i=0;i<col;i++) {
			for(int j=0;j<row;j++) {
				if(i == 0 || i == col - 1) {
					System.out.print("B");
				}else {
					if(j>0 && j<=col) {
						System.out.print("Y");
					}else {
						System.out.print("B");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("row : " + answer[0]);
		System.out.println("col : " + answer[1]);
		System.out.println("Square Size : " + answer[0] + "X" + answer[1]);
	}
}
