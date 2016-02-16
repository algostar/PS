/*
 * @(#)Problem2228_YG.java $version 2016. 1. 18.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.study.week2;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2228_YG {
	public static void main(String[] args){
		new Problem2228_YG().run();
	}
	
	int n;
	int m;
	int[][] dp;
	int[] a;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		dp = new int[n][m+1];
		a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		
		int sum =0;
		for(int i=0;i<n;i++){
			sum += a[i];
			dp[i][1] = sum;
		}
		
		for(int i=0;i<n;i++){
			for(int j=1;j<m;j++){
				int psum =0;
				for(int k=i+1;k<n;k++){
					psum+=a[k];
					dp[k][j+1] = Math.max(dp[k][j+1], Math.max(dp[i][j], psum));
				}
			}
		}
		
		System.out.println(dp[n-1][m]);
	}
}
