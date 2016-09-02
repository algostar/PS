package seattle.algostar.ps.codeforce.contest.div2_369;

import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		new ProblemA().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int lineCnt = sc.nextInt();
		String[] res = new String[lineCnt];
		boolean poss = false;
		for (int i = 0; i < lineCnt; i++) {
			char[] line = sc.next().toCharArray();
			
			for (int ix = 0; !poss && ix <= 3; ix+=3) {
				if ( !poss && line[ix] == 'O' && line[ix+1] == 'O') {
					poss = true;
					line[ix] = '+';
					line[ix+1] = '+';
				}
			}
			
			res[i] = String.valueOf(line);
		}
		
		if (poss) {
			System.out.println("YES");
			for (String r : res) System.out.println(r);
		} else {
			System.out.println("NO");
		}
	}
}
