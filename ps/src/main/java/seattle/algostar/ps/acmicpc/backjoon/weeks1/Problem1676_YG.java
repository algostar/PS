/*
 * @(#)Problem1676_YG.java $version 2015. 12. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem1676_YG {
	public static void main(String[] args){
		new Problem1676_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt =0;
		for(int i=1;i<=n;i++){
			int d = i;
			while(d%5 == 0){
				d /= 5; cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
