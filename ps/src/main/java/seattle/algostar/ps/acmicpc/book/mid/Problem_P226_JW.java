package seattle.algostar.ps.acmicpc.book.mid;

import java.util.Scanner;

public class Problem_P226_JW {
	public static void main(String[] args) {
		new Problem_P226_JW().solve();
	}

	int nn;
	
	private void solve() {
		Scanner sc = new Scanner(System.in);
		nn = sc.nextInt();
		getSeq(1, "1");
		getSeq(1, "2");
		getSeq(1, "3");
	}
	
	String minGoodSeq;

	private void getSeq(int n, String seq) {
		
		if (!isGoodSeq(seq)) return ;
		
		if (n == nn) {
			if (minGoodSeq == null) {
				minGoodSeq = seq;
			} else {
				minGoodSeq = minGoodSeq.compareTo(seq) < 0 ? minGoodSeq : seq;
			}
			return ;
		}
		
		getSeq(nn+1, seq + "1");
		getSeq(nn+1, seq + "2");
		getSeq(nn+1, seq + "3");
	}

	private boolean isGoodSeq(String seq) {
		for (int sz = 1; seq.length() - 2*sz < 0 ; sz++) {
			int sameCnt = 0;
			for (int step = 0; step <= sz; step++) {
				int siNew = seq.length() - sz;
				int siGood = siNew - sz;
				
				if (seq.charAt(siNew + step) == seq.charAt(siGood + step)) {
					sameCnt++;
				}
			}
			if (sameCnt == sz) return false;
		}
		return true;
	}

}
