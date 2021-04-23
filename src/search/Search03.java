package search;

// 프로그래머스 완전탐색 레벨2 카펫
public class Search03 {
	public static int[] solution(int brown, int yellow) {	
		int row=0;
		int col=0; 

		int yellowTiles = yellow;
		if(yellow % 2 == 0) {
			while(4*yellowTiles >brown) {
				yellowTiles /= 2; 
			}
		}else {
			if(yellow % 3 == 0) {
				while(4*yellowTiles >brown) {
					yellowTiles  /= 3; 
				}		
			}
		}
		row = yellowTiles+2; 
		col = yellow/yellowTiles+2;	
		int[] answer = {row, col};

		for(int i=0;i<col;i++) {
			for(int j=0;j<row;j++) {
				if(i == 0 || i == col - 1) {
					System.out.print("B");
				}else {
					if(j>0 && j<=yellowTiles) {
						System.out.print("Y");
					}else {
						System.out.print("B");
					}
				}
			}
			System.out.println();
		}
		
		return answer; 
	}
	public static void main(String[] args) {
		// 테스트 케이스
		int brown = 50;
		int yellow = 22;
		
		int[] answer = solution(brown, yellow);
		
		System.out.println("row : " + answer[0]);
		System.out.println("col : " + answer[1]);
		System.out.println("Square Size : " + answer[0] + "X" + answer[1]);
	}
}
