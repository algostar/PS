/*
 * @(#)Problem2011.java $version 2015. 11. 23.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Problem2011 {
	public static void main(String[] args){
		new Problem2011().run();
	}
	
	int[] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char[] inputs = input.toCharArray();
		
		cache = new int[inputs.length + 1];
		cache[0] = 1;
		cache[1] = 1;
		
		for(int i =2; i <= inputs.length; i++){
			int deter = (inputs[i-2] - '0') * 10 + inputs[i-1] - '0';
			cache[i] = inputs[i-1] == '0' ? 0 : cache[i-1];
			if(deter >= 10 && deter <=26) cache[i] = (cache[i] + cache[i-2]) % 1000000;
		}
		
		System.out.println(cache[inputs.length]);
	}
}
