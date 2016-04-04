package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2854_JW {
	public static void main(String[] args) throws IOException {
		new Problem2854_JW().solve();
	}

	long MOD = 1000000007;
	private void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nn = Integer.parseInt(st.nextToken());
		
		int[] A = new int[nn+1];
		int[] B = new int[nn+1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 1; i <= nn; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			if (i == 1) continue;
			B[i] = Integer.parseInt(st2.nextToken());
		}
		
		long[][] F = new long[nn+1][2];
		F[0][0] = 1;
		for (int i = 1; i <= nn; i++) {
			F[i][0] = F[i-1][0] * (A[i] + B[i]) % MOD;
			F[i][0] += F[i-1][1] * (A[i] + B[i] - 1) % MOD;
			if (i+1 > nn) continue;
			F[i][1] = F[i-1][0] * B[i+1] % MOD;
			F[i][1] += F[i-1][1] * B[i+1] % MOD;
		}
		System.out.println( (F[nn][0] + F[nn][1]) % MOD );
	}
}
