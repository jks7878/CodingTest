package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 프로그래머스 정렬 레벨2 H-Index
public class Sort03 {
	public static int solution(int[] citations) {	
		int answer = 0;
		List<Integer> temp = new ArrayList<Integer>();
		temp = Arrays.stream(citations).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		// 참고 : https://wakestand.tistory.com/419
		// stream을 사용해 citations 배열을 내림차순으로 정렬한 값을 temp list에 저장
		
		for(int i=0;i<temp.size();i++) {
			if(i > temp.get(i)) {
				break;
			}
			answer++;
		}
		// 참고 : https://www.ibric.org/myboard/read.php?Board=news&id=270333
		// 문제 해설
		// 논문이 인용된 횟수가 저장된 배열 citations를 내림차순으로 배열한 뒤 for문을 통해 answer를 하나씩 count
		// 논문이 인용된 횟수가 count보다 작아질 경우 break 하고 answer 값 반환 
		
		/*
		 * citations =
		 * Arrays.stream(citations).boxed().sorted(Collections.reverseOrder()).mapToInt(
		 * Integer::intValue).toArray(); for(int i=0;i<citations.length;i++){
		 * if(citations[i] <= i){ break; } answer++; }
		 */
		return answer;
	}
	public static void main(String[] args) {
		// 테스트 케이스
		int[] citations = {4, 4, 4, 5, 0, 1, 2, 3};
		
		System.out.println(solution(citations));
	}
}
