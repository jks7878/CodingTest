package hash;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 해시 레벨2 위장
public class hash03 {
	// 경우의 수 문제
	public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1); 
            // 옷을 카테고리(ex.header, eyewear) 별로  구분 value값에 getOrDefault를 사용해 개수를 입력 => +1을 하지 않을 경우 default 0이 들어감
        }
        for(int val : map.values()){
        	System.out.println("val : " + val);
            answer *= (val+1); // 해당 카테고리의 옷을 안 입는 경우의 수를 포함시키기 위해 +1
            // 카테고리별로 저장된 개수를 곱한다
        }
        return answer-1; // 전부 안 입는 경우의 수는 없기 때문에 최종값에서 -1
	}
	public static void main(String[] args) {
		String[][] clothes = {
				{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"},
				{"redshirts" , "top"}, {"blackjean", "bottom"}, {"normalglasses", "eyewear"}, {"brownhat", "headgear"}
				};
		System.out.println(solution(clothes));
	}
}
