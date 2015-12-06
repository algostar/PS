/*
 * @(#)Problem1102.java $version 2015. 12. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1102 {
	public static void main(String[] args){
		new Problem1102().run();
	}
	
	int[][] cost;
	int[][] dp;
	int n;
	int p;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		cost = new int[n][n];
		for(int i = 0;i<n;i++){
			for(int j =0;j<n;j++){
				cost[i][j] = sc.nextInt();
			}
		}
		char[] des = sc.next().toCharArray();
		p = sc.nextInt();
		
		dp = new int[1<<17][p+1];
		for(int i =0; i < 1<<17; i++){
			Arrays.fill(dp[i], 987654321);
		}
		int start =0; int startp =0;
		for(int i = des.length-1; i >= 0; i--){
			if(des[i] == 'Y'){
				start += Math.pow(10, i);
				startp++;
			}
		}
		dp[start][startp] = 0;
		
		for(int i = 0; i < 1<<n; i++ ){
			for(int j = 1; j < p; j++){
				int min = 987654321;
				for(int k = 0; k < n; k++){
					if((i & (1<<k)) == 1){
						min = Math.min(min, dp[i&1<<k][p-1]);
					}
				}
				
				dp[i][j] = min;
			}
		}
		int rst = 987654321;
		for(int i =0;i < 1<<n;i++){
			rst = Math.min(rst, dp[i][p]);
		}
		
		System.out.println(rst == 987654321 ? -1 : rst);
	}
}
