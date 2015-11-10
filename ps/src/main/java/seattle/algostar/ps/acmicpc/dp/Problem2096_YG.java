/*
 * @(#)Problem2096.java $version 2015. 10. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2096_YG {
	public static void main(String[] args){
		new Problem2096_YG().run();
	}
	
	int n;
	int[][] a;
	int[][] max;
	int[][] min;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		max = new int[n+2][3]; min = new int[n+2][3]; a = new int[n+2][3];
		
		for(int i = 1; i <= n; i++){
			Arrays.fill(min[i], Integer.MAX_VALUE);
		}
		
		for(int i = 1; i<=n; i++){
			for(int j = 0; j < 3; j++){
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 1; i<=n+1; i++){
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + a[i][0];
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + a[i][1];
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + a[i][2];
			
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + a[i][0];
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + a[i][1];
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + a[i][2];
		}
		
		System.out.println(max[n+1][1] + " " + min[n+1][1]);
	}
}
