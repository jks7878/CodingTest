package search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 프로그래머스 완전탐색 레벨2 소수 찾기
public class Search02 {
	static boolean[] check = new boolean[7];
	static List<Integer> answers = new ArrayList<Integer>();
	static void find(int length, String[] numbers, StringBuilder sb) {	
		// [1,2,3]	
		for(int i=0;i<length;i++) {
			if(!check[i]) {
				sb.append(numbers[i]);
				if(!answers.contains(Integer.parseInt(sb.toString()))) {
					answers.add(Integer.parseInt(sb.toString()));
				}
				check[i] = true;		
				find(length, numbers, sb);
				check[i] = false;
				sb.deleteCharAt(sb.length() - 1);			
			}
		}
	} 
	
	public static int solution(String numbers) {
		int answer = 0;	
		int length = numbers.length();
		
		String[] temp = numbers.split("");
		StringBuilder sb = new StringBuilder();
		
		find(length, temp, sb);	
		System.out.println(answers);
		int max = Collections.max(answers);
		if(max == 0 || max == 1) {
			return 0;
		}
		System.out.println(max);
		for(int i=2;i<max;i++) {	
			for(int j=answers.size()-1;j>-1;j--) {
				if(answers.size() == 0) {
					break;
				}				
				if(answers.get(j) == 0 || answers.get(j) == 1) {
					answers.remove(j);
				}else if(answers.get(j) != i && answers.get(j) % i == 0) {
					answers.remove(j);
				}
			}				
		}
		System.out.println(answers);
		return answer = answers.size();
	}
	public static void main(String[] args) {
		// 테스트케이스
		String numbers = "001";
		System.out.println(solution(numbers));
	}
}
