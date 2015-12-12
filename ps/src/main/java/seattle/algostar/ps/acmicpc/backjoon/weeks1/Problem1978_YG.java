/*
 * @(#)Problem1978_YG.java $version 2015. 12. 12.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem1978_YG {
	public static void main(String[] args){
		new Problem1978_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0;i<n;i++){
			in[i] = sc.nextInt();
		}
		int rst =0;
		for(int i=0;i<n;i++){
			if(isPrime(in[i])) rst++;
		}
		System.out.println(rst);
	}
	
	public boolean isPrime(int a){
		if(a < 2) return false;
		for(int i=2;i*i<=a;i++){
			if(a%i == 0){
				return false;
			}
		}
		return true;
	}
}
