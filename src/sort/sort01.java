package sort;

import java.util.Arrays;

// 프로그래머스 정렬 레벨 1 K번째 수
public class sort01 {
	public static void main(String[] args) {
		// 테스트 케이스
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] answer = new int[commands.length];
			
		int[] temp;
		for(int i=0;i<commands.length;i++) {
			temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
			// java.util.Arrays의 copyOfRange 함수 사용
			// 테스트케이스 1 번 배열의 값은 {2, 5, 3} 2번째 부터 5번째 값까지 자르고 정렬 후 3번째 값을 answer 배열에 추가
			// n번째 값의 인덱스는 n - 1이므로 commands[i][0] - 1
			// copyOfRange의 end값은 해당 인덱스 전까지 자르기때문에 추가로 -1 하지 않음 (== 5를 넣을경우 4번 인덱스까지 자름)
			Arrays.sort(temp);
			
			answer[i] = temp[commands[i][2] - 1];
			// n번째 값의 인덱스 == n - 1
		}
		for(int j : answer) {
			System.out.print(j + " ");
		}
	}
}
