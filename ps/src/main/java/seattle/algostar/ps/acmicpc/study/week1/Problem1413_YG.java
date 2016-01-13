/*
 * @(#)Problem1413_YG.java $version 2016. 1. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.study.week1;

import java.util.Scanner;

public class Problem1413_YG {
	public static void main(String[] args){
		new Problem1413_YG().run();
	}
	
	int n;
	int m;
	long[][] dp;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		dp = new long[n+1][m+1];
		for(int i=0;i<=m;i++){
			dp[0][i]=1;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				dp[i][j] = dp[i-1][j-1] + (i-1)*dp[i-1][j];
			}
		}
		
		long t = fac(n);
		long g = gcd(dp[n][m], t);
		System.out.println((dp[n][m] / g) + "/" + (t/g));
	}
	
	public long fac(int a){
		if(a==0) return 1;
		return a*fac(a-1);
	}
	
	public long gcd(long a, long b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
