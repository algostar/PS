/*
 * @(#)Problem2216.java $version 2015. 11. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2216_YG {
	public static void main(String[] args){
		new Problem2216_YG().run();
	}
	
	int a,b,c;
	public void run(){
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
		
		String input1 = sc.next();
		String input2 = sc.next();
		
		int input1L = input1.length();
		int input2L = input2.length();
		int maxLength = Math.max(input1.length(), input2.length());
		
		int[][] cache = new int[maxLength + 1][maxLength + 1];
				
		for(int i = 0; i < maxLength + 1; i++){
			Arrays.fill(cache[i], Integer.MIN_VALUE);
		}
		
		for(int i = 0; i <= input1L; i++){
			cache[i][0] = i * b;
		}
		
		for(int i = 0; i <= input2L; i++){
			cache[0][i] = i * b;
		}
		
		for(int i = 1; i <= input1L; i++){
			for(int j = 1; j <= input2L; j++){
				if(input1.charAt(i - 1) == input2.charAt(j - 1)){
					cache[i][j] = Math.max(cache[i][j], cache[i -1][j - 1] + a);
				}else{
					cache[i][j] = Math.max(cache[i][j], cache[i -1][j - 1] + c);
				}
				
				cache[i][j] = Math.max(cache[i][j], cache[i][j - 1] + b);
				cache[i][j] = Math.max(cache[i][j], cache[i - 1][j] + b);
			}
		}
		
		System.out.println(Arrays.deepToString(cache));
		System.out.println(cache[input1L][input2L]);
	}
}
