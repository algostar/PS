/*
 * @(#)Problem10828_YG.java $version 2015. 12. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;
import java.util.Stack;

public class Problem10828_YG {
	public static void main(String[] args) {
		new Problem10828_YG().run();
	}

	Stack<Integer> stk = new Stack<Integer>();

	public void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String nextOp = sc.next();
			if (nextOp.equals("push")) {
				stk.push(sc.nextInt());
			} else {
				System.out.println(operator(nextOp));
			}
		}
	}

	public int operator(String op) {
		if (op.equals("pop")) {
			return stk.isEmpty() ? -1 : stk.pop();
		} else if (op.equals("size")) {
			return stk.size();
		} else if (op.equals("empty")) {
			return stk.isEmpty() ? 1 : 0;
		} else {
			return stk.isEmpty() ? -1 : stk.peek();
		}
	}
}
