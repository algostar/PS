package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.*;

public class Problem2605_JW {
	public static void main(String[] args) {
		new Problem2605_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		List<Integer> lst = new LinkedList<Integer>();
		sc.nextInt();
		lst.add(1);
		for (int n = 2; n <= nn; n++) {
			int num = sc.nextInt();
			int lastPos = lst.size();
			int insertIx = lastPos - num;
			lst.add(insertIx, n);
		}
		
		for (int i = 0; i < nn; i++) {
			System.out.print(lst.get(i));
			if (i != nn - 1) System.out.print(" ");
		}
	}
}
