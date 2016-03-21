/*
 * @(#)Problem10942_YG.java $version 2016. 3. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem10942_YG {
	public static void main(String[] args){
		new Problem10942_YG().run();
	}
	
	int n;
	int q;
	int[] a;
	int[][] cache;
	
	public void run(){
		Scanner sc = new Scanner (System.in);
		n =sc.nextInt();
		a = new int[n+1];
		cache = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			a[i]=sc.nextInt();
		}
		
		cache[n][n]=1;
		for(int i=n-1;i>=0;i--){
			cache[i][i]=1;
			for(int j=i+1;j<=n;j++){
				if(a[i]==a[j]) cache[i][j]=(j==i+1)?1:cache[i+1][j-1];
			}
			
		}
		int k=sc.nextInt();
		for(int i=0;i<k;i++){
			System.out.println(cache[sc.nextInt()][sc.nextInt()]);
		}
	}
}
