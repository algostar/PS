/*
 * @(#)Problem11004_YG.java $version 2015. 12. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11004_YG {
	public static void main(String[] args) throws IOException {
		new Problem11004_YG().run();
	}

	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(tokenizer.nextToken());
		int k = Integer.valueOf(tokenizer.nextToken());

		tokenizer = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(tokenizer.nextToken());
		}
		System.out.println(quickSelect(a, 0, a.length - 1, k - 1));
	}

	private int quickSelect(int[] aa, int s, int e, int k) {
		while (s < e) {
			int p = s + (int)Math.random()*(e-s+1);
			swap(aa, p, s);
			p = s;
			int l = s + 1;
			int r = e;

			while (l <= r) {
				while (l <= e && aa[p] >= aa[l]) l++;
				while (r >= s + 1 && aa[p] <= aa[r]) r--;
				if (l < r) swap(aa, r, l);
			}
			swap(aa, r, p);
			if (k == r) return aa[k];
			if (k < r) {
				e = r - 1;
			} else {
				s = r + 1;
			}
		}
		return aa[s];
	}

	private void swap(int[] t, int a, int b) {
		int temp = t[a];
		t[a] = t[b];
		t[b] = temp;
	}
}
