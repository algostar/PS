package seattle.algostar.ps.review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestReview5 {
	public static void main(String[] args) {

		int n = 6;
		int[] P = {6, -7, 3, -1, 5, 10};
		sol1(P);
	}
	private static void sol1(int[] P) {
		int n = P.length;
		int[] DP = new int[n];
		
		int max = 0;
		DP[0] = P[0];
		for (int i = 1; i < n; i++) {
			DP[i] = Math.max(DP[i-1] + P[i], P[i]);
			max = Math.max(max, DP[i]);
		}
		System.out.println(max);
	}
}
