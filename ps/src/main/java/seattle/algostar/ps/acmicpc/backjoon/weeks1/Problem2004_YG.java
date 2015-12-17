/*
 * @(#)Problem2004_YG.java $version 2015. 12. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Scanner;

public class Problem2004_YG {
	public static void main(String[] args){
		new Problem2004_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int b= sc.nextInt();
		long twoCnt = 0;
		long fiveCnt =0;
		twoCnt = f(a, 2) - f(a-b,2) - f(b,2);
		fiveCnt = f(a,5) - f(a-b,5)-f(b,5);
		long min = Math.min(twoCnt, fiveCnt);
		System.out.println(min<=0?0:min);
	}
	
	public long f(int d, int div){
		if(div == 0) return 0;
		
		long cnt =0;
		for(long i=div;i<=d;i*=div){
			cnt += d/i;
		}
		return cnt;
	}
}
