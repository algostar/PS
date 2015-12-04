/*
 * @(#)Problem10886.java $version 2015. 12. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.Scanner;

public class Problem10886 {
	public static void main(String[] args){
		new Problem10886().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cuteCount = 0;
		
		for(int i = 0; i < n; i++){
			if(sc.nextInt() == 0){
				cuteCount--;	
			}else{
				cuteCount++;
			}
		}
		
		System.out.println(cuteCount > 0 ? "Junhee is cute!" : "Junhee is not cute!");
		
	}
}
