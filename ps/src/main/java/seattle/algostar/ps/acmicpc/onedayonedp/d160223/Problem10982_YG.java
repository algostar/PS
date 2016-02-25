/*
 * @(#)Problem10982_YG.java $version 2016. 2. 24.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem10982_YG {
	public static void main(String[] args){
		new Problem10982_YG().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();

		while(cases-- >0){
			int n = sc.nextInt();
			int[] ov1 = new int[n+1];
			int[] ov2 = new int[n+1];
			int[] cache = new int[100*n+1];
			Arrays.fill(cache, 987654321);
			int total=0;
			for(int i=1;i<=n;i++){
				ov1[i]=sc.nextInt();
				ov2[i]=sc.nextInt();
				total+=ov1[i];
			}
			
			for(int i=1;i<=n;i++){
				
			}
		}
	}
}
