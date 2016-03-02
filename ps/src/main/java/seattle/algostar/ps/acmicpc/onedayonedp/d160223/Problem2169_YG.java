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
	int[][][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		a = new int[n+2][m+2]; cache = new int[n+2][m+2][3];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				a[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0;i<n+2;i++){
			for(int j=0;j<m+2;j++){
				Arrays.fill(cache[i][j], -987654321);
			}
		}
		
		cache[1][0][2]=0;
		for(int i=1;i<=n;i++){
			for(int k=0;k<3;k++){
				if(k==0 || k==2){
					for(int j=1;j<=m;j++){
						cache[i][j][0] = Math.max(cache[i][j][0], cache[i-1][j][0] + a[i][j]);
						cache[i][j][0] = Math.max(cache[i][j][0], cache[i-1][j][1] + a[i][j]);
						cache[i][j][0] = Math.max(cache[i][j][0], cache[i-1][j][2] + a[i][j]);
						cache[i][j][2] = Math.max(cache[i][j][2], cache[i][j-1][2] + a[i][j]);
						cache[i][j][2] = Math.max(cache[i][j][2], cache[i][j-1][0] + a[i][j]);
					}
				}else{
					for(int j=m;j>=1;j--){
						cache[i][j][1] = Math.max(cache[i][j][1], cache[i][j+1][1] + a[i][j]);
						cache[i][j][1] = Math.max(cache[i][j][1], cache[i][j+1][0] + a[i][j]);
					}
				}	
			}
		}
		System.out.println(Math.max(cache[n][m][2], Math.max(cache[n][m][0], cache[n][m][1])));
	}
}
