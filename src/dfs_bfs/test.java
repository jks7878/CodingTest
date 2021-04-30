package dfs_bfs;

public class test {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int max = 1;
		
		int answer = 5;
		int cnt = 0;
		
		for(int i : arr) {
			max *= 2;
		}

		int cur = 0;
		while(cur < max) {
			int sum = 0;
			int tmp = 0;
			for(int i=0;i<arr.length;i++) {
				tmp = cur;
				if((tmp >> i & 1) == 1) {
					sum += 1 * arr[i];
				}else {
					sum += -1 * arr[i];
				}
			}		
			System.out.println(sum);
			if(sum == answer) {
				cnt++;
			}
			cur++;
		}
		System.out.println();
		System.out.println(cnt);
	}
}
