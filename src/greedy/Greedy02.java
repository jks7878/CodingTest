package greedy;

// 프로그래머스 그리디 레벨2 조이스틱
public class Greedy02 {
    public static int solution(String name) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<name.length();i++) {
        	sb.append("A");
        }

        int right = 0;
        int left = 0;
        int cur = 0;
        while(true) {
        	int cnt = name.charAt(cur) - sb.charAt(cur);
    		if(cnt > 13) {
        		cnt = 25 - cnt + 1;
        	} 		 	
        	answer += cnt;
        	
        	sb.setCharAt(cur,(name.charAt(cur)));
        	if(sb.toString().equals(name)) {
        		break;
        	}   	
        	
        	right = 0;
        	for(int i=0;i<sb.length();i++) {
        		if(sb.charAt(i) == 'A' && name.charAt(i) != 'A') {
        			break;
        		}
        		right++;
        	}   	
        	right = Math.abs((sb.length() - cur + right)%sb.length());
        	left = 0;
        	for(int i=sb.length()-1;i>0;i--) {
        		left++;
        		if(sb.charAt(i) == 'A' && name.charAt(i) != 'A') {
        			break;
        		} 
        	}       	 
        	left = Math.abs((sb.length() + cur + left)%sb.length());
        	System.out.println("right : " + right);
        	System.out.println("left : " + left);
        	
        	if(right<left) {
        		cur += right;
        		answer += right;
        	}else if(right>left) {
        		cur -= left;
        		answer += left;
        	}else {
        		cur += right;
        		answer += right;	
        	}
        	
    		if(cur > name.length() - 1) {
    			cur %= (name.length());
    		}else if(cur < 0) {
        		cur = name.length() + cur;
    		}
        	System.out.println("커서 위치 : " + cur);
        }
        
    	System.out.println(sb);
        return answer;
    }
	
	public static void main(String[] args) {
		// 테스트 케이스
//		String name = "ZA"; // = 1
//		String name = "ABAA"; // = 2
//		String name = "JEROEN"; // = 56
//		String name = "BBBAAAB"; // = 9
//		String name = "JAZA"; // = 12
//		String name = "JAN"; // = 23
//		String name = "AZAAZ"; // = 5
		String name = "BAAZAZZ"; // = 7
	
		int answer = solution(name);

		System.out.println(answer + "번");
	}
}