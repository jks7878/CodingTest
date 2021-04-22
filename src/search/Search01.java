package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 완전탐색 레벨1 모의고사 
public class Search01 {
	public static int[] solution(int[] answers) {
		int[] answer = {};
		
		int[][] test = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
		int[] cnt = {0,0,0};

		for(int i=0;i<answers.length;i++) {
			if(answers[i] == test[0][i%5]) {
				cnt[0]++;
			}
			if(answers[i] == test[1][i%8]) {
				cnt[1]++;
			}
			if(answers[i] == test[2][i%10]) {
				cnt[2]++;
			}
		}
		
		int sum = 0;
		for(int i : cnt) {
			sum += i;
		}
		if(sum == 0) {
			return answer = new int[] {};
		}
		
		List<Integer> temp = new ArrayList<Integer>();
		int max = 0;
		temp.add(1);
		for(int i=0;i<cnt.length;i++) {	
			if(cnt[max] < cnt[i]) {
				max = i;
				temp.clear();
				temp.add(i+1);
			}else if(max != i && cnt[max] == cnt[i]) {
				max = i;
				temp.add(i+1);
			}
		}

		System.out.println("temp");
		for(int i : temp) {
			System.out.println(i);
		}
		
		answer = temp.stream().mapToInt(i->i).toArray();		
		Arrays.sort(answer);
		System.out.println("answer");
		for(int i : answer) {
			System.out.println(i);
		}
		
 		return answer;
	}
	public static void main(String[] args) {
		// 테스트 케이스
//		int[] answers = {5,4,4,2,1}; // = []
//		int[] answers = {1,2,3,4,5}; // = [1]	
		int[] answers = {2,1,2,3,2}; // = [2]
//		int[] answers = {3,3,1,1,2}; // = [3]
//		int[] answers = {1,2,2,3,4}; // = [1,2]
//		int[] answers = {3,3,2,3,1}; // = [2,3]
//		int[] answers = {1,2,1,1,4}; // = [1,3]
//		int[] answers = {1,3,2,4,2}; // = [1,2,3]
		
	

		int[] answer = solution(answers);
	}

}
