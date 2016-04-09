package seattle.algostar.ps.acmicpc.codejam2016.qulification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Revenge_JW {
	public static void main(String[] args) throws FileNotFoundException {
		new Revenge_JW().solve();
	}

	private void solve() throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream(new File("/home/mosaick/B-large.in")));
		PrintWriter out = new PrintWriter(new FileOutputStream("/home/mosaick/B-large.out"));
		
		int nn = sc.nextInt();
		for (int t = 1; t <= nn; t++) {
			char[] S = sc.next().toCharArray();
			int cnt = 0;
			for (int i = S.length-1; i >= 0; i--) {
				if (S[i] != '+') {
					if (S[0] == '-') {
						cnt += flip(S, i);
					} else {
						int kk = 0;
						for (int k = 1; k < i && S[kk] == S[k]; k++) {
							kk = k;
						}
						cnt += flip(S, kk);
						cnt += flip(S, i);
					}
				}
			}
			out.println("Case #" + t + ": " + cnt);
			out.flush();
		}
		out.close();
		System.out.println("==END==");
	}

	private int flip(char[] S, int i) {
		char[] fliped = new char[i+1];
		for (int j = i; j >= 0; j--) {
			fliped[i - j] = S[j] == '+' ? '-' : '+';
		}
		for (int j = 0; j <= i; j++) {
			S[j] = fliped[j];
		}
		return 1;
	}
}
