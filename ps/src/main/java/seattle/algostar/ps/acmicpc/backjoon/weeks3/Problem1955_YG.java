/*
 * @(#)Problem1955_YG.java $version 2016. 3. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1955_YG {
	public static void main(String[] args){
		new Problem1955_YG().run();
	}
	
	int n;
	int[] cache;
	int[] fac = new int[10001];
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		cache=new int[n+1];
		int f=1;
		for(int i=1;i<8;i++){
			f*=i;
			fac[f]=i;
		}
		Arrays.fill(cache, 987654321);
		cache[1]=1;
		for(int i=2;i<=n;i++){
			if(fac[i]!=0) cache[i]=Math.min(cache[i], cache[fac[i]]);
			cache[i]=Math.min(cache[i], cache[i-1]+1);
			for(int j=2;j<i/2;j++){
				cache[i]=Math.min(cache[i], cache[i-j]+cache[j]);
			}
			
			for(int j=2;j*j<=i;j++){
				if((i-(i/j)*j)==0){
					cache[i]=Math.min(cache[i], cache[j]+cache[i/j]);
				}
			}
		}
		System.out.println(cache[n]);
	}
}
