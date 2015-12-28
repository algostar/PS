package seattle.algostar.ps.acmicpc.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem9507_JW {
	public static void main(String[] args) {
		new Problem9507_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int s = 68;
		BigInteger[] DT = new BigInteger[s];
		
		
		DT[0] = BigInteger.ONE; DT[1] = DT[0]; DT[2] = BigInteger.valueOf(2); DT[3] = BigInteger.valueOf(4);
		for (int i = 4; i < s; i++) DT[i] = DT[i-1].add(DT[i-2]).add(DT[i-3]).add(DT[i-4]);
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(DT[n]);
		}
	}
}
