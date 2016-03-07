/*
 * @(#)Problem1128_YG.java $version 2016. 3. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem1128_YG {
	public static void main(String[] args){
		new Problem1128_YG().run();
	}
	
	public void run(){
		long a=1; long b=1; long c=0;
		long cnt=0;
		while(b<10000000000L){
			c=b;
			b=a+b;
			a=c;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}
