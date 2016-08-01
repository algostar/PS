package seattle.algostar.ps.acmicpc.temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestReview {
	public static void main(String[] args) {

		int[] A = {100, 50, 30};
		int[] B = {65, 30, 15};
		int[] P = {10, 13, 21, 35, 43};
		
		sol1(A, B, P);
		sol2(A, B, P);
		sol3(A, B, P);
	}

	private static void sol3(int[] A, int[] B, int[] P) {
		TreeMap<Integer, Boolean> set = new TreeMap<Integer, Boolean>();
		for (int i = 0; i < P.length; i++) {
			set.put(P[i], true);
		} 
		
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int rest = A[i] - B[i];
			Integer r = set.floorKey(rest);
			if (r == null) {
				R[i] = -1;
			} else {
				R[i] = r;
			}
		}
		System.out.println(Arrays.toString(R));
	}
	
	private static void sol2(int[] A, int[] B, int[] P) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < P.length; i++) {
			set.add(P[i]);
		} 
		
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int rest = A[i] - B[i];
			Integer r = set.floor(rest);
			if (r == null) {
				R[i] = -1;
			} else {
				R[i] = r;
			}
		}
		System.out.println(Arrays.toString(R));
	}

	private static void sol1(int[] A, int[] B, int[] P) {
		int[] R = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			int s = 0, e = P.length-1;
			int rest = A[i] - B[i];
			while (s < e) {
				int m = (s + e + 1)/2;
				if (rest < P[m]) {
					e = m - 1;
				} else {
					s = m;
				}
			}
			R[i] = s+1;
		}
		System.out.println(Arrays.toString(R));
	}
}
