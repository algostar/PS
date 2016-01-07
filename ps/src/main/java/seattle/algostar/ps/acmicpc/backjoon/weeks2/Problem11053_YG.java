/*
 * @(#)Problem11053_YG.java $version 2016. 1. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Scanner;

public class Problem11053_YG {
	public static void main(String[] args){
		new Problem11053_YG().run();
	}
	
	int[] a;
	int[] dp;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n]; dp=new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			dp[i]=1;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(a[i]>a[j]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		int rst=0;
		for(int i=0;i<n;i++){
			rst = Math.max(rst, dp[i]);
		}
		System.out.println(rst);
	}
}
