package greedy;

import java.util.Arrays;
import java.util.HashSet;

// 프로그래머스 그리디 레벨1 체육복
public class Greedy01 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = lost.length;
      
        // 테스트 케이스 3,4,8 틀리길래 오름차순 정렬 추가
        lost = Arrays.stream(lost).sorted().toArray();
        reserve = Arrays.stream(reserve).sorted().toArray();
        
        // 옷을 빌려주는 게 불가능한 학생들을 체크하기 위한 해시셋
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < lost.length; i++) {
        	for (int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					// 잃어버린 학생과 여분의 체육복을 갖고 있는 학생이 일치할 경우 add
					hash.add(reserve[j]);
				}
			}
		}
 
        for (int i = 0; i < lost.length; i++) {
			// 여분의 체육복을 도둑맞은 학생들은 수업이 가능하기 때문에 --
			if(hash.contains(lost[i])) {
				answer--;
				continue;
			}else {
	        	System.out.println("잃어버린 학생 : " + lost[i]);
				for (int j = 0; j < reserve.length; j++) {
					// 여분의 체육복을 도둑 맞은 게 아닌 학생들 중 조건에 맞을 경우 --
					if(!hash.contains(reserve[j])) {
						if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
							System.out.println(reserve[j]);
							// 중복 조회 방지를 위해 해당 index의 값을 0으로 변경
							lost[i] = 0;
							reserve[j] = 0;
							answer--;
						}
					}				
				}			
			}
		}
 
        return n-answer;
    }
    
	public static void main(String[] args) {
		// 테스트 케이스
		int n = 3;
		int[] lost = {1,2};
		int[] reserve = {2,3};
		
		int answer = solution(n, lost, reserve);

		System.out.println("수업을 들을 수 있는 학생 수 : " + answer);
	}
}
