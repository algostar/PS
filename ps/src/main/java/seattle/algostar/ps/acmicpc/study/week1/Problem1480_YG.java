/*
 * @(#)Problem1480_TG.java $version 2016. 1. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.study.week1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1480_YG {
	public static void main(String[] args){
		new Problem1480_YG().run();
	}
	int nn;
	int mm;
	int cc;
	
	int[] a;
	int[][][] dp;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		nn = sc.nextInt();
		mm = sc.nextInt();
		cc = sc.nextInt();
		dp = new int[nn][mm][cc+1];
		a = new int[nn];
		for(int i=0;i<nn;i++){
			a[i] = sc.nextInt();
		}
		int[] inputC = new int[mm];
		Arrays.fill(inputC, cc);
		
		for(int i=0;i<nn;i++){
			for(int j=0;i<mm;i++){
				dp[i][j][a[i]]=1;
			}
		}
		for(int i=1;i<nn;i++){
			for(int j=0;j<mm;j++){
				for(int k=0;k<=cc;k++){
					for(int r=0;r<=j;r++){
						if(a[i] <= inputC[j] && k-a[i]>=0){
							dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][r][k-a[i]]+1);
						}
					}
				}
			}
		}
		
		int rst =0;
		for(int i=1;i<nn;i++){
			for(int j=0;j<mm;j++){
				for(int k=0;k<=cc;k++){
					rst = Math.max(rst, dp[i][j][cc]);
				}
			}
		}
		
		System.out.println(rst);
	}
}
