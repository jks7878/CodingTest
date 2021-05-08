package graph;

import java.util.HashSet;
import java.util.Stack;

public class test02 {

	public static void main(String[] args) {
		int n = 5;
		int k = 4;
		
		String answer = "";
		StringBuilder sb = new StringBuilder();
		sb.append("OOXXXO");
	
		Stack<Integer> stack = new Stack<Integer>();	
		HashSet<Integer> hash = new HashSet<Integer>();
		stack.add(1);
		hash.add(1);
		stack.add(2);
		hash.add(2);
		stack.add(3);
		hash.add(3);
		
		int num = 2;
		for(int i=0;i<num;i++) {
			k--;
			if(stack.contains(k)) {
				i-=1;
			}
			if(k < 0) {
				k = 0;
			}
		}
		sb.setCharAt(k, 'S');
//		while(stack.contains(k)) {
//			if(k == n - 1 && stack.contains(k)) {
//				if(stack.contains(k)) {
//					while(stack.contains(k)) {
//						k--;
//					}
//				}
//				break;
//			}
//			k++;
//		}

		System.out.println(hash);
		System.out.println(sb);
	}
}
