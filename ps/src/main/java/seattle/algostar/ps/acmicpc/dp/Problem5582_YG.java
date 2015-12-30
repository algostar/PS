/*
 * @(#)Problem5582.java $version 2015. 12. 29.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem5582_YG {
	public static void main(String[] args){
		new Problem5582_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		char[] in1 = sc.next().toCharArray();
		char[] in2 = sc.next().toCharArray();
		int[] dp = new int[in2.length+1];
		int rst = -1;
		for(int i=0;i<in1.length;i++){
			for(int j=0;j<in2.length;j++){
				if(in1[i] == in2[j]){
					dp[i+1] = dp[i] + 1;
				}
				rst = Math.max(dp[i+1], rst);
			}
		}
		System.out.println(rst);
	}
}
