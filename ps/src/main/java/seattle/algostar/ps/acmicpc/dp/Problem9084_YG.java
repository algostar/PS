/*
 * @(#)Problem9084_YG.java $version 2015. 12. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem9084_YG {
	public static void main(String[] args){
		new Problem9084_YG().run();
	}
	
	int n;
	int[] coin;
	int k;
	int[][] dp;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		while(cases-- >0){
			n = sc.nextInt();
			coin = new int[n];
			for(int i =0;i<n;i++){
				coin[i] = sc.nextInt();
			}
			
			int k = sc.nextInt();
			dp = new int[n+1][k+1];
			dp[0][0]=1;
			for(int i=0;i<n;i++){
				for(int j=coin[i];j<=k;j++){
					dp[i+1][j] += dp[i][j-coin[i]];
				}
			}
			System.out.println(dp[n][k]);
		}
	}
}
