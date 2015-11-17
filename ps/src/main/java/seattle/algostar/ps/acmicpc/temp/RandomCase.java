package seattle.algostar.ps.acmicpc.temp;

import java.util.Scanner;

public class RandomCase {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int rnum = (int)(Math.random() * 10);
				System.out.print(rnum);
				if (j != n-1) System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
