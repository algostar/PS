/*
 * @(#)Problem1727_YG.java $version 2016. 4. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160413;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1727_YG {
	public static void main(String[] args){
		new Problem1727_YG().run();
	}
	
	int n;
	int m;
	int[] a;
	int[] b;
	int[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		a=new int[n+1]; b= new int[m+1];
		cache=new int[n+1][m+1];
		for(int i=1;i<=n;i++) a[i]=sc.nextInt();
		for(int i=1;i<=m;i++) b[i]=sc.nextInt();
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				cache[i][j]=987654321;
			}
		}
		Arrays.sort(a); Arrays.sort(b);
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				cache[i][j]=Math.min(cache[i][j], cache[i-1][j-1]+Math.abs(a[i]-b[j]));
				if(i>j){
					cache[i][j]=Math.min(cache[i][j], cache[i-1][j]);
				}
				if(i<j){
					cache[i][j]=Math.min(cache[i][j], cache[i][j-1]);
				}
			}
		}
		
		System.out.println(cache[n][m]);
	}
}
