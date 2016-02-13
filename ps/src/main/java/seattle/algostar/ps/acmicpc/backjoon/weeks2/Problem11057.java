/*
 * @(#)Problem11057.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Scanner;

public class Problem11057 {
	public static void main(String[] args){
		new Problem11057().run();
	}
	
	int n;
	int[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache = new int[n+1][10];
		
		for(int i=0;i<10;i++) cache[1][i] =1;
		for(int i=2;i<=n;i++){
			for(int j=0;j<=9;j++){
				for(int k=0;k<=j;k++){
					cache[i][j] += cache[i-1][k];
					cache[i][j] %= 10007;
				}
			}
		}
		int rst=0;
		for(int i=0;i<10;i++){
			rst+=cache[n][i];
		}
		System.out.println(rst%10007);
	}
}


