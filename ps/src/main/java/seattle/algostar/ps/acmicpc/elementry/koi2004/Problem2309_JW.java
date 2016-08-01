package seattle.algostar.ps.acmicpc.elementry.koi2004;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2309_JW {
	public static void main(String[] args) {
		new Problem2309_JW().run();
	}

	private void run() {
		int size = 9;
		int[] A = new int[size];
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for (int i = 0; i < size; i++) {
			A[i] = sc.nextInt();
			sum += A[i];
		}
		
		Arrays.sort(A);
		
		int restSum = sum - 100;
		int restIx1 = -1, restIx2 = -1;
		for (int i = 0; i < size; i++) {
			int ix = Arrays.binarySearch(A, restSum - A[i]);
			if (ix >= 0 && ix != i) {
				restIx1 = i;
				restIx2 = ix;
				break;
			}
		}
		for (int i = 0; i < size; i++) {
			if (i != restIx1 && i != restIx2) {
				System.out.println(A[i]);
			}
		}
	}
}
