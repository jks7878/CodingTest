package greedy;

public class test01 {
    public static int solution(String name) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<name.length();i++) {
        	sb.append("A");
        }

        boolean aCheck = true;
        int aCnt = 0;
        int cur = 0;
        while(true) {
        	int cnt = name.charAt(cur) - sb.charAt(cur);
    		if(cnt > 13) {
        		cnt = 25 - cnt + 1;
        	} 		 	
        	answer += cnt;

        	if(aCheck && cur != 0 && name.charAt(cur) != 'A') {
        		aCheck = false;
        	}else if(aCheck && cur != 0 && name.charAt(cur) == 'A'){
        		aCnt++;
        	}

        	sb.setCharAt(cur,(name.charAt(cur)));
        	if(sb.toString().equals(name)) {
        		if(cur == name.length() - 1) {
        			answer -= aCnt;	
        		}
        		break;
        	}
    		answer++;	
        	cur++;
        }

        return answer;
    }
	
	public static void main(String[] args) {
		// 테스트 케이스
//		String name = "ZA"; // = 1
//		String name = "ABAA"; // = 2
		String name = "BBBAAAB";
//		String name = "JAZA"; // = 12
//		String name = "JAN"; // = 23
//		String name = "AZAAZ"; // = 6
//		String name = "BAAZAAZ"; // = 7	
		int answer = solution(name);

		System.out.println(answer + "번");
	}
}
