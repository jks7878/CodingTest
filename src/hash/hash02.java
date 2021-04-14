package hash;

import java.util.Arrays;
import java.util.HashMap;

// 프로그래머스 해시 레벨2 전화번호 목록
public class hash02 {
	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		
		Arrays.sort(phone_book); 
		// 테스트 케이스 8,9번 통과를 위해 배열을 먼저 정렬
		// ex)4321, 43일 경우 정렬을 하지 않으면 실패함
		HashMap<String, String> map = new HashMap<String, String>();
        for(int i=0;i<phone_book.length;i++){
        	String arg = phone_book[i];
//        	System.out.println("arg : " + arg);
        	map.put(arg, arg);  //대상을 넣습니다.
        	for(int j=0;j < arg.length();j++){ //본인의 키 값 패턴이 다른곳에도 있는지 
        		String str = arg.substring(0,j);  //하나하나 늘려가며
//        		System.out.println("mini : " + str);
        		if(map.get(str) != null){  //조사합니다.
        			return false;
        		}
        	}   
        }
        return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 테스트케이스
		String[] phone_book = {"4321", "198", "115524421", "43"};
		
		System.out.println(solution(phone_book));
	}

}
