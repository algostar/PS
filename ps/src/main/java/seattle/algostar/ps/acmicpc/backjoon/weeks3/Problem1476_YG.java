/*
 * @(#)Problem1476_YG.java $version 2016. 2. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks3;

import java.util.Scanner;

public class Problem1476_YG {
	public static void main(String[] args){
		new Problem1476_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b= sc.nextInt();
		int c = sc.nextInt();
		
		int rst =0;
		for(int i=1;i<=15*28*29;i++){
			int a1 = i%15; a1=a1==0?15:a1;
			int b1 = i%28; b1=b1==0?28:b1;
			int c1 = i%19; c1=c1==0?19:c1;
			
			if(a1==a&&b1==b&&c1==c){
				rst =i;
				break;
			}
		}
		System.out.println(rst);
	}
}
