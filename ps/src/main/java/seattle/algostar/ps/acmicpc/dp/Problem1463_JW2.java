package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1463_JW2 {
	public static void main(String[] args) {
		new Problem1463_JW2().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] cache =  new int[N + 1];
		Arrays.fill(cache, (int)1e9);
		cache[1] = 0;
		for (int i = 1; i <= N; i++) {
			if (i * 3 <= N) cache[i*3] = Math.min(cache[i*3], cache[i] + 1);
			if (i * 2 <= N) cache[i*2] = Math.min(cache[i*2], cache[i] + 1);
			if (i + 1 <= N) cache[i+1] = Math.min(cache[i+1], cache[i] + 1);
		}
		System.out.println(cache[N]);
	}
}
