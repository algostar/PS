package seattle.algostar.ps.acmicpc.elementry.koi2016;

import java.util.Scanner;

public class Problem10833_JW {
	public static void main(String[] args) {
		new Problem10833_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		
		int sum = 0;
		for (int i = 0; i < nn; i++) {
			int stu = sc.nextInt();
			int app = sc.nextInt();
			
			sum += (app % stu);
		}
		System.out.println(sum);
	}
}
