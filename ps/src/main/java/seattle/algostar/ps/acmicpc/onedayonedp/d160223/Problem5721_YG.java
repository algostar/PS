/*
 * @(#)Problem5721_YG.java $version 2016. 2. 25.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Scanner;

public class Problem5721_YG {
	public static void main(String[] args){
		new Problem5721_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int m=sc.nextInt(); int n=sc.nextInt();
			if(m==0 && n==0) break;
			int[][] a = new int[m][n]; int[] cache = new int[m];
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					a[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<m;i++){
				int[] g= new int[n];
				for(int j=0;j<n;j++){
					g[j] = Math.max(j-1>=0?g[j-1]:0, j-2>=0?g[j-2]+a[i][j]:a[i][j]);
				}
				cache[i] = Math.max(i-1>=0?cache[i-1]:0, i-2>=0?cache[i-2]+g[n-1]:g[n-1]);
			}
			System.out.println(cache[m-1]);
		}
	}
}
