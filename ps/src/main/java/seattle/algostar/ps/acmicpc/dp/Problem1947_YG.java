package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1947_YG {
	int k;
	long[] cache;
	
	public static void main(String[] args){
		new Problem1947_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt(); cache = new long[2];
		
		cache[0] = 1;
		cache[1] = 0;
		for(int i = 2; i <= k; i++){
			cache[i % 2] = ((i - 1) * ( cache[(i - 1) % 2] + cache[(i - 2) % 2])) % 1000000000L;
		}
		System.out.println(cache[k % 2]);
	}
}	
