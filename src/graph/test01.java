package graph;

public class test01 {
    public static int find(StringBuilder sb){
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
        for(int i=0;i<eng.length;i++){
            if(sb.toString().equals(eng[i])){
                return i;
            }
        }
        return -1;
    }
    
    public static int solution(String s) {
        int answer = 0;
        String str = "";
        StringBuilder sb = new StringBuilder();        
    	int i = 0;
        while(i != s.length()){
        	System.out.println(s.charAt(i));
        	sb.append(s.charAt(i));
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){           	
                int find = -1;
                while(true){
                    System.out.println(sb);
                    find = find(sb);
                    if(find >= 0){
                        break;
                    }
                    i++;
                    sb.append(s.charAt(i));
                }
                str += Integer.toString(find);
            }else {
            	str += sb.toString();	
            }         
            System.out.println(str);
            sb.delete(0, sb.length());
            i++;
        }
        answer = Integer.parseInt(str);

        return answer;
    }
	public static void main(String[] args) {
		String s = "one4seveneight";
		int answer = solution(s);
		System.out.println(answer);
	}
}
