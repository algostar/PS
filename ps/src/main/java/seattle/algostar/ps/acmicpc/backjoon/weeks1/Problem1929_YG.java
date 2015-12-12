/*
 * @(#)Problem1929_YG.java $version 2015. 12. 12.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem1929_YG {
	public static void main(String[] args){
		new Problem1929_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); int n =sc.nextInt();
		boolean[] ip = new boolean[n+1];

		for(int i=2;i*i<=n;i++){
			if(!ip[i]){
				for(int j=i*i;j<=n;j+=i){
					ip[j] = true;
				}
			}
		}
		
		for(int i=2;i<=n;i++){
			if(!ip[i] && i>=m) System.out.println(i);
		}
	}
}
