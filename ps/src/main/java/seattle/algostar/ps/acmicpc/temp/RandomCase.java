package seattle.algostar.ps.acmicpc.temp;

import java.util.Scanner;

public class RandomCase {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int rnum = (int)(Math.random() * n) + 1;
			System.out.print(rnum + " ");
		}
		
	}
}
