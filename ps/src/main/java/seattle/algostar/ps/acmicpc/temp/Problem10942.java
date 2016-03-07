/*
 * @(#)Problem10942.java $version 2016. 3. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.util.Scanner;

public class Problem10942 {
	public static void main(String[] args){
		new Problem10942().run();
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
		
		for(int i=1;i<=n;i++){
			int k=i;
			int j=i;
			cache[k][j]=1;
			k--; j++;
			while(k>=1 && j<=n && a[k]==a[j]){
				cache[k][j]=1;
				k--; j++;
			}
			
			k=i;
			j=i+1;
			
			while(k>=1 && j<=n && a[k]==a[j]){
				cache[k][j]=1;
				k--; j++;
			}
			
		}
		int k=sc.nextInt();
		for(int i=0;i<k;i++){
			System.out.println(cache[sc.nextInt()][sc.nextInt()]);
		}
	}
}
