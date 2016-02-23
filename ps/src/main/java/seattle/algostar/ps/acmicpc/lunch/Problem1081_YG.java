/*
 * @(#)Problem1081_YG.java $version 2016. 2. 23.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.lunch;

import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem1081_YG {
	public static void main(String[] args){
		new Problem1081_YG().run();
	}
	
	char[] a;
	char[] b;
	long first;
	long[] s;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		first = Integer.valueOf(sc.next());
		a = String.valueOf(first-1).toCharArray();
		b = sc.next().toCharArray();
		
		s = new long[10];
		
		for(int i=1;i<=9;i++){
			long ten = 1;
			for(int j=1;j<=i;j++){
				ten*=10;
			}
			s[i] = 45*ten*i/10;
		}
		System.out.println(sum(b, b.length) - sum(a, a.length));
	}
	
	public long sum(char[] c, int n){
		if(n>c.length) return 0;
		
		int num = c[n-1] - '0';
		long rst = 0;
		
		long subSum=0;
		for(int j=0;j<n-1;j++){
			subSum += c[j];
		}
		
		long ten = 1;
		for(int j=1;j<=c.length-n;j++){
			ten*=10;
		}
		
		for(int i=0;i<num;i++){
			rst += s[c.length-n] + ten*(subSum+i);
		}
		return rst;
	}
}
