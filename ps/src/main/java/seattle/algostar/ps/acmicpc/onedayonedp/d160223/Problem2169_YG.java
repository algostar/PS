/*
 * @(#)Problem2169_YG.java $version 2016. 2. 23.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2169_YG {
	public static void main(String[] args){
		new Problem2169_YG().run();
	}
	
	int n,m;
	int[][] a;
	int[][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		a = new int[n+2][m+1]; cache = new int[n+2][m+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				a[i][j]=sc.nextInt();
			}
		}
		Arrays.fill(cache[1], -987654321);
		cache[1][1] = a[1][1];
		for(int i=2;i<=n+1;i++){
			Arrays.fill(cache[i], -987654321);
			
			int[] psum = new int[m+1];
			for(int j=1;j<=m;j++){
				psum[j]=psum[j-1]+a[i-1][j];
			}
			
			for(int j=1;j<=m;j++){
				for(int k=1;k<=m;k++){
					int p=0;
					if(k<j){
						p=psum[j]-psum[k];
					}else{
						p=psum[k-1]-psum[j-1];
					}
					cache[i][j] = Math.max(cache[i][j], cache[i-1][k]+p+a[i][j]);
				}
			}
		}
		System.out.println(cache[n+1][m]);
	}
}
