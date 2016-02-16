/*
 * @(#)Problem11726_YG.java $version 2016. 2. 13.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.util.Scanner;

public class Problem11726_YG {
	public static void main(String[] args){
		new Problem11726_YG().run();
	}
	
	int n;
	int[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); cache = new int[n+2];
		cache[1] = 1; cache[2]=2;
		for(int i=3;i<=n;i++){
			cache[i] = (cache[i-1]+cache[i-2])%10007;
		}
		
		System.out.println(cache[n]);
	}
}
