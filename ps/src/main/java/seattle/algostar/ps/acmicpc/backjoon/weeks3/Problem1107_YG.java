/*
 * @(#)Problem1107_YG.java $version 2016. 2. 21.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks3;

import java.util.Scanner;

public class Problem1107_YG {
	public static void main(String[] args){
		new Problem1107_YG().run();
	}
	
	int n;
	boolean[] broken = new boolean[10];
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int brokensize = sc.nextInt();
		
		for(int i=0;i<brokensize;i++){
			broken[sc.nextInt()] = true;
		}
		
		int min = Math.abs(100-n);
		for(int i=0;i<999999;i++){
			int l = len(i);
			if(l > 0){
				min = Math.min(min, l + Math.abs(i-n));
			}
		}
		System.out.println(min);
	}
	
	public int len(int a){
		int len=0;
		if(a==0) return broken[a] ? 0 : 1;
		while(a>0){
			if(broken[a%10]) return 0;
			len+=1;
			a/=10;
		}
		return len;
	}
}
