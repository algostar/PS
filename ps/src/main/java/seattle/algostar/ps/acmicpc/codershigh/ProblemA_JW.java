package seattle.algostar.ps.acmicpc.codershigh;

import java.util.Scanner;

public class ProblemA_JW {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tt = sc.nextInt();
		
		for (int t = 0; t < tt; t++) {
			int hp = sc.nextInt();
			int mp = sc.nextInt();
			int ap = sc.nextInt();
			int dp = sc.nextInt();
			
			hp += sc.nextInt();
			mp += sc.nextInt();
			ap += sc.nextInt();
			dp += sc.nextInt();
			
			hp = (hp < 1) ? 1 : hp;
			mp = (mp < 1) ? 1 : mp;
			ap = (ap < 0) ? 0 : ap;
			
			System.out.println(hp + 5*mp + 2*ap + 2*dp);
		}
	}
}
