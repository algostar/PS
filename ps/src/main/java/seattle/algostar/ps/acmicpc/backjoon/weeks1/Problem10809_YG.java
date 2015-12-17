/*
 * @(#)Problem10809_YG.java $version 2015. 12. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem10809_YG {
	public static void main(String[] args){
		new Problem10809_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		int[] a = new int[26];
		Arrays.fill(a,  -1);
		for(int i=0;i<in.length;i++){
			a[in[i]-'a'] = a[in[i]-'a'] == -1 ? i:a[in[i] -'a'];
		}
		for(int i=0;i<26;i++) System.out.print(a[i] + " ");
	}
}