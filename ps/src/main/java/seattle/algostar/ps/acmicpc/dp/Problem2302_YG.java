package seattle.algostar.ps.acmicpc.dp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



/*
 * @(#)Problem2302.java $version 2015. 11. 19.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem2302_YG {
	public static void main(String[] args){
		new Problem2302_YG().run();
	}
	
	int n;
	int[] cache;
	Set<Integer> vip = new HashSet<Integer>();
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cache = new int[n + 1];
		int vipSize = sc.nextInt();
		
		for(int i =0; i<vipSize; i++){
			vip.add(sc.nextInt());
		}
		
		cache[1] = 1; cache[0] = 1;
		
		for(int i = 2; i <= n; i++){
			cache[i] = cache[i-1];
			if(!vip.contains(i) && !vip.contains(i -1)){
				cache[i] += cache[i-2];
			}
		}
		
		System.out.println(cache[n]);
	}
}
