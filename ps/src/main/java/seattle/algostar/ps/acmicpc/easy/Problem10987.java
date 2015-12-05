/*
 * @(#)Problem10987.java $version 2015. 12. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.Scanner;

public class Problem10987 {
	public static void main(String[] args){
		new Problem10987().run();
	}
	
	char[] in;
	public void run(){
		Scanner sc = new Scanner(System.in);
		in = sc.next().toCharArray();
		
		System.out.println(f(in.length - 1));
	}
	
	public int f(int index){
		if(index  == -1) return 0;
		return (in[index] == 'a' || in[index] == 'e' || in[index] == 'i' || in[index] == 'o' || in[index] == 'u') ? f(index -1) + 1: f(index -1);
			
	}
}
