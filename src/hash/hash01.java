package hash;

import java.util.HashMap;
import java.util.Map;

//완주하지 못한 선수
public class hash01 {
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String p : participant) {
			System.out.println(p + " : " + map.getOrDefault(p, 0));
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		/* System.out.println("=============================================="); */
		for(String c : completion) {
			System.out.println(c + " : " + map.get(c));
			map.put(c, map.get(c) - 1);
		}
		/*
		 * System.out.println("==============================================");
		 * System.out.println(map);
		 */
		for(String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
				break;
			}
		}	
		
		return answer;
	}
	public static void main(String[] args) {		
		// 테스트케이스
		/*
		 * String[] participant = {"mislav", "stanko", "mislav", "ana"}; String[]
		 * completion = {"stanko", "ana", "mislav"};
		 */
		
		String[] participant = {"mislav", "stanko", "mislav", "ana", "mariana", "mariana", "mislav", "leo", "josipa"};
		String[] completion = {"mislav", "stanko", "mislav", "mislav", "mariana", "mariana", "ana", "leo"};
		
		
		System.out.println("완주하지 못한 선수 : " + solution(participant, completion));
	}
}
