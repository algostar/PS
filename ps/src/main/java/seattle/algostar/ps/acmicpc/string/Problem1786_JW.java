package seattle.algostar.ps.acmicpc.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1786_JW {
	public static void main(String[] args) {
		new Problem1786_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		String t = sc.nextLine();
		String p = sc.nextLine();
		
		int ix = 0;
		List<Integer> ixs = new ArrayList<Integer>();
		while (ix != -1) {
			ix = t.indexOf(p, ix+1);
			if (ix != -1) {
				ixs.add(ix+1);
			}
		}
		System.out.println(ixs.size());
		for (int i = 0; i < ixs.size(); i++) {
			System.out.print(ixs.get(i));
			System.out.print(" ");
		}
	}
}
