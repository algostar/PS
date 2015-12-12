/*
 * @(#)Problem11576_YG.java $version 2015. 12. 12.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem11576_YG {
	public static void main(String[] args){
		new Problem11576_YG().run();
	}
	
	int b;
	public void run(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		b = sc.nextInt();
		int s = sc.nextInt();
		int[] in = new int[s];
		for(int i=0;i<s;i++){
			in[i] = sc.nextInt();
		}
		int ten =0;
		for(int i=0;i<s;i++){
			ten = ten*a + in[i];
		}
		
		f(ten);
	}
	
	public void f(int a){
		if(a < b){
			System.out.print(a + " ");
			return;
		}
		
		f(a/b);
		System.out.print((a- (a/b)*b) + " ");
	}
}	
