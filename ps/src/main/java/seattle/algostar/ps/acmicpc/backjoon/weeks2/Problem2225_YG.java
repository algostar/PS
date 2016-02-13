/*
 * @(#)Problem2225_YG.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Scanner;

public class Problem2225_YG {
	public static void main(String[] args){
		new Problem2225_YG().run();
	}
	
	int n;
	int k;
	int[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		cache = new int[n+1][k+1];
		for(int i=0;i<=k;i++) cache[0][i]=1;
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				for(int r=0;r<=i;r++){
					cache[i][j] += cache[i-r][j-1];
					cache[i][j] %= 1000000000;
					
				}
			}
		}
		System.out.println(cache[n][k]);
	}
}
