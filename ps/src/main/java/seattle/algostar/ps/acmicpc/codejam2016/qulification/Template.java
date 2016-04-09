/*
 * @(#)Template.java $version 2015. 4. 11.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.codejam2016.qulification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Template {
	public static void main(String args[]) throws Exception {
		new Template().run();
	}

	public void run() throws Exception {
		Scanner sc = new Scanner(new FileInputStream(new File("C:\\codejam\\q2.txt")));
		PrintWriter out = new PrintWriter(new FileOutputStream("C:\\codejam\\q2_out.txt"));
		int cases = sc.nextInt();
		int size = cases;

		while (cases-- > 0) {
			//out.println("Case #" + String.valueOf(size - cases) + ": " + Answer());
			out.flush();
		}
		out.close();
		System.out.println("===end==");
	}

	public void Answer() {
		
	}
}
