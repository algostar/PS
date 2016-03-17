package seattle.algostar.ps.acmicpc.onedayonedp.d160316;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1234_JW {
	public static void main(String[] args) {
		new Problem1234_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		int G = sc.nextInt();
		int B = sc.nextInt();
		
		long[] fac = new long[11];
		fac[0] = 1;
		for (int i = 1; i <= 10; i++) {
			fac[i] = fac[i-1] * i;
		}
		
		long[][][][] DT = new long[N+1][R+1][G+1][B+1];
		for (int r = 0; r <= R; r++) {
			for (int g = 0; g <= G; g++) {
				Arrays.fill(DT[0][r][g], 1);
			}
		}
		
		for (int n = 1; n <= N; n++) {
			for (int r = 0; r <= R; r++) {
				for (int g = 0; g <= G; g++) {
					for (int b = 0; b <= B; b++) {
						if (n % 3 == 0) {
							if (r - n/3 >= 0 && g - n/3 >= 0 && b - n/3 >= 0) {
								DT[n][r][g][b] += DT[n-1][r - n/3][g - n/3][b - n/3] * (fac[n]/fac[n/3]/fac[n/3]/fac[n/3]);
							}
						}
						if (n % 2 == 0) {
							if (r - n/2 >= 0 && g - n/2 >= 0) {
								DT[n][r][g][b] += DT[n-1][r - n/2][g - n/2][b] * (fac[n]/fac[n/2]/fac[n/2]);
							}
							if (r - n/2 >= 0 && b - n/2 >= 0) {
								DT[n][r][g][b] += DT[n-1][r - n/2][g][b - n/2] * (fac[n]/fac[n/2]/fac[n/2]);
							}
							if (g - n/2 >= 0 && b - n/2 >= 0) {
								DT[n][r][g][b] += DT[n-1][r][g - n/2][b - n/2] * (fac[n]/fac[n/2]/fac[n/2]);
							}
						}
						
						if (r - n >= 0) {
							DT[n][r][g][b] += DT[n-1][r - n][g][b];
						}
						
						if (g - n >= 0) {
							DT[n][r][g][b] += DT[n-1][r][g - n][b];
						}
						
						if (b - n >= 0) {
							DT[n][r][g][b] += DT[n-1][r][g][b - n];
						}
					}
				}
			}
		}
		System.out.println(DT[N][R][G][B]);
	}
}
