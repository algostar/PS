/*
 * @(#)Problem1761_YG2.java $version 2016. 7. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem1761_YG2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		new Problem1761_YG().run();
	}

	List<List<Tree>> g;
	int dest;
	int n;
	int m;
	int[] pa;

	public void run() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		g = new ArrayList<List<Tree>>();
		for (int i = 0; i < n + 1; i++) {
			g.add(new ArrayList<Tree>());
		}
		pa =new int[n+1];
		for (int i = 1; i < n; i++) {
			String[] in = br.readLine().split(" ");
			int from = Integer.valueOf(in[0]);
			int to = Integer.valueOf(in[1]);
			int value = Integer.valueOf(in[2]);
			g.get(from).add(new Tree(to, value));
			pa[to]=from;
		}
		m = Integer.valueOf(br.readLine());
		for (int i = 0; i < m; i++) {
			String[] in = br.readLine().split(" ");
			int from = Integer.valueOf(in[0]);
			dest = Integer.valueOf(in[1]);
			System.out.println(f(from, dest));
		}
	}

	public int f(int from, int to) {
		Queue<Integer> fromq = new LinkedList<Integer>();
		Queue<Integer> fromqw = new LinkedList<Integer>();
		Queue<Integer> toq = new LinkedList<Integer>();
		Queue<Integer> toqw = new LinkedList<Integer>();
		
		return 0;
	}

	public class Tree {
		int v;
		int w;

		public Tree(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
