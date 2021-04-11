package hash;

import java.util.Arrays;
import java.util.HashSet;

public class hash02 {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashSet<String> set = new HashSet<String>();
		Arrays.sort(phone_book);
		for(String p : phone_book) {
			for(String s : set) {
				if(s.startsWith(p) || s.startsWith(p)) {
					return false;
				}
			}
			set.add(p);
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 테스트케이스
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}

}
