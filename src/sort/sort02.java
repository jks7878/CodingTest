package sort;

import java.util.Arrays;
import java.util.Comparator;

// 프로그래머스 정렬 레벨2 가장 큰 수
public class sort02 {
	public static String solution(int[] numbers) {
		String answer = "";
		String[] temp = new String[numbers.length];
			
		for (int i=0;i<numbers.length;i++) {
			temp[i] = Integer.toString(numbers[i]);
		}
		// Comparator 사용 
		// 출처 : https://gmlwjd9405.github.io/2018/09/06/java-comparable-and-comparator.html
		Arrays.sort(temp, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2); // == 내림차순 (o1+o2).compareTo(o2+o1) == 오름차순
			}
		});

        if(temp[0].startsWith("0")){
            answer += "0"; // 테스트케이스 11번이 값이 0인 배열이기 때문에 제어문으로 추가
        }else{
           	for(String s2 : temp) {
			    answer += s2;
            }
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// 테스트 케이스
		int[] numbers = { 3, 30, 34, 5, 9 };
		// int[] numbers = { 6, 10, 2 };

		System.out.println(solution(numbers));
	}

}
