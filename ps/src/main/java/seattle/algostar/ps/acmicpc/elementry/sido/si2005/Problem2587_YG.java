/*
 * @(#)Problem2587_YG.java $version 2016. 8. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2005;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2587_YG {
	public static void main(String[] args){
		new Problem2587_YG().run();
	}
	
	int[] s = new int[5];
	public void run(){
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for(int i=0;i<5;i++){
			s[i]=sc.nextInt();
			sum+=s[i];
		}
		Arrays.sort(s);
		System.out.println(sum/5);
		System.out.println(s[2]);
	}
}
