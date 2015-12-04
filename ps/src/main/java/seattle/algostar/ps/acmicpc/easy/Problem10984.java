/*
 * @(#)Problem10984.java $version 2015. 12. 3.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.Scanner;

public class Problem10984 {
	public static void main(String[] args){
		new Problem10984().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		while(cases-- > 0){
			int n = sc.nextInt();
			int sum = 0; float valueSum = 0f;
			
			for(int i = 0; i < n; i++){
				int now = sc.nextInt();
				sum += now;
				valueSum += sc.nextFloat() * now;
			}
			
			System.out.println(sum + " " + Math.round((valueSum / sum) * 10) / 10f);
		}
	}
}
