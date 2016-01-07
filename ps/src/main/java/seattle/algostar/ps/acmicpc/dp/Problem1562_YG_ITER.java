/*
 * @(#)Problem1562_YG_ITER.java $version 2016. 1. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1562_YG_ITER {
	public static void main(String[] args){
		new Problem1562_YG_ITER().run();
	}
	
	int[][][] dp;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1][10][1<<10];
		for(int i=1;i<10;i++) dp[1][i][1<<i]=1;
		for(int i=1;i<n;i++){
			for(int j=0;j<10;j++){
				for(int k=0;k<1<<10;k++){
					if(j>=1) dp[i+1][j-1][k|(1<<j-1)] = (dp[i+1][j-1][k|(1<<j-1)] + dp[i][j][k])%1000000000;
					if(j<=8) dp[i+1][j+1][k|(1<<j+1)] = (dp[i+1][j+1][k|(1<<j+1)] + dp[i][j][k])%1000000000;
				}
			}
		}
		int rst =0;
		for(int i=0;i<10;i++){
			rst=(dp[n][i][1023] + rst)%1000000000;
		}
		System.out.println(rst);	
	}
}
