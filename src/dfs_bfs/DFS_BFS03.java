package dfs_bfs;

// 프로그래머스 DFS/BFS 레벨3 단어 변환
public class DFS_BFS03 {
	static int search(StringBuilder sb, String target, String[] words, int changed, int answer) {
		String temp = sb.toString();	
		boolean change = false;
		boolean correct = false;
		
		System.out.println("answer : " + answer);
		if(sb.toString().equals(target)) {
			correct = true;
		}else {
			for(int i=0;i<target.length();i++) {	
				sb.setCharAt(i, target.charAt(i));
				if(i != changed) {
					for(int j=0;j<words.length;j++) {
						System.out.println("후보 : " + words[j]);
						if(sb.toString().equals(words[j]) && !sb.toString().equals(temp)) {
							answer++;
							change = true;
							return answer = search(sb, target, words, i, answer);						
						}
					}				
				}
				if(!change) {
					sb.setCharAt(i, temp.charAt(i));			
				}
			}				
			for(int i=0;i<target.length();i++) {		
				if(i != changed) {
					for(int j=0;j<words.length;j++) {
						sb.setCharAt(i, words[j].charAt(i));				
						if(sb.toString().equals(words[j]) && !sb.toString().equals(temp)) {
							answer++;
							change = true;
							return answer = search(sb, target, words, i, answer);				
						}
					}				
				}
				if(!change) {
					sb.setCharAt(i, temp.charAt(i));			
				}
			}			
		}
		
		if(correct) {
			return answer;
		}else {
			return 0;
		}
	}
	static int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		StringBuilder sb = new StringBuilder(begin);	
		answer = search(sb, target, words, -1, 0);			
			
		return answer;
	}
	public static void main(String[] args) {
		// 테스트 케이스
//		String begin = "hit";
//		String target = "cog";
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		// = 4
		
//		String begin = "hit";
//		String target = "cog";
//		String[] words = {"hot", "dot", "dog", "lot", "log"};
		// = 0
		
		String begin = "hot";
		String target = "lot";
		String[] words = {"hot", "dot", "dog", "lot", "log"}; 
		// = 1
		
		int answer = solution(begin, target, words);
		
		System.out.println("times : " + answer);
	}
}
