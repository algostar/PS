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
		
		dp = new int[1<<17][17];
		for(int i =0; i < 1<<17; i++){
			Arrays.fill(dp[i], 987654321);
		}
		int start =0; int startp =0;
		for(int i = 0; i < des.length; i++){
			if(des[i] == 'Y'){
				start += Math.pow(2, i);
				startp++;
			}
		}
		if(startp > p){
			System.out.println(0);
			return;
		}
		dp[start][startp] = 0;
		
		for(int i = 0; i <(1<<n); i++){
			for(int j = startp; j < p; j++){
				for(int k = 0; k < n; k++){
					if((i & (1<<k)) == 0){
						int min = 987654321;
						for(int r =0; r<n;r++){
							if((i &(1<<r)) != 0){
								min = Math.min(min, cost[r][k]);
							}
						}
						dp[i|(1<<k)][j+1] = Math.min(dp[i|(1<<k)][j+1], dp[i][j] + min);
					}
				}
			}
		}
		int rst = 987654321;
		for(int i =0;i<(1<<n);i++){
			rst = Math.min(rst, dp[i][p]);
		}
		
		System.out.println(rst == 987654321 ? -1 : rst);
	}
}
