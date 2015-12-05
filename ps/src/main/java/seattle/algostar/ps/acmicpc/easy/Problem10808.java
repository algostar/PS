/*
 * @(#)Problem10808.java $version 2015. 12. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.Scanner;

public class Problem10808 {
	public static void main(String[] args){
		new Problem10808().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		char[] input = sc.next().toCharArray();
		int[] count = new int[26];
		
		for(char elem : input){
			count[elem - 'a']++;
		}
		
		for(int i = 0; i < 26; i++){
			System.out.print(count[i] + " ");
		}
	}
}
