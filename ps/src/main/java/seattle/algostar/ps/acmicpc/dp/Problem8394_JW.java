package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem8394_JW {
	public static void main(String[] args) {
		new Problem8394_JW().run();
	}

	
	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] A = new int[3];
		A[1] = 1; A[2] = 2;
		for (int i = 3; i <= n; i++) {
			A[i % 3] = (A[(i-1) % 3] + A[(i-2) % 3]) % 10; 
		}
		System.out.println(A[n % 3]);
	}
}
