/*
 * @(#)Problem9613.java $version 2015. 12. 8.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem9613_YG {
	public static void main(String[] args){
		new Problem9613_YG().run();
	}
	
	int[] in;
	public void run(){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while(cases-- > 0){
			int n = sc.nextInt(); in = new int[n];
			
			for(int i =0; i<n;i++){
				in[i] = sc.nextInt();
			}
			
			int sum = 0;
			for(int i =0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					sum+=gcd(in[i], in[j]);
				}
			}
			
			System.out.println(sum);
		}
	}
	
	public int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
