package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10990_JW {
	public static void main(String[] args) {
		new Problem10990_JW().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = f(n);
	}

	private String f(int n) {
		String res = "*";
		if (n != 1) {
			int size = f(n-1).length();
			char[] space = new char[size];
			Arrays.fill(space, ' ');
			res = "*" + String.valueOf(space) +"*";
		}
		System.out.println(res);
		return res;
	}
}
