/*
 * @(#)Problem1670.java $version 2016. 3. 28.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem1670_YG {
	public static void main(String[] args){
		new Problem1670_YG().run();
	}
	
	int n;
	long[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache=new long[n+1];
		cache[0]=1;
		cache[2]=1;
		for(int i=4;i<=n;i+=2){
			for(int j=0;j<=i-2;j+=2){
				cache[i]+=(cache[j]*cache[i-(j+2)])%987654321;
				cache[i]%=987654321;
			}
		}
		System.out.println(cache[n]);
	}
}
