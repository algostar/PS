/*
 * @(#)Problem9095.java $version 2015. 11. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem9095_YG {
	public static void main(String[] args){
		new Problem9095_YG().run();
	}
	
	int[] dp;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
	
		int cases = sc.nextInt();
		
		while(cases-- > 0){
			n = sc.nextInt();
			dp = new int[n + 1];
			
			if(n == 1){
				System.out.println(1);
			}else if(n == 2){
				System.out.println(2);
			}else{
				dp[0] = 1; dp[1] = 1; dp[2] = 2;
				
				for(int i = 3; i <= n; i++){
					dp[i] = dp[i -1] + dp[i-2] + dp[i-3];
				}
				
				System.out.println(dp[n]);
			}
		}
	}
}
