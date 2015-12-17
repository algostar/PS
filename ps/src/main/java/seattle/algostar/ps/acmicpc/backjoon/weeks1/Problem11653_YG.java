/*
 * @(#)Problem11653_YG.java $version 2015. 12. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11653_YG {
	public static void main(String[] args){
		new Problem11653_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=2;i*i<=n;i++){
			while(n%i == 0){
				System.out.println(i);
				n /= i;
			}
		}
		
		if(n>1){
			System.out.println(n);
		}
		
	}
}
