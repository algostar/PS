/*
 * @(#)Problem5502_YG.java $version 2016. 3. 31.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.Scanner;

public class Problem5502_YG {
	public static void main(String[] args){
		new Problem5502_YG().run();
	}
	
	int n;
	int[][] cache;
	char[] in;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		cache = new int[n+1][n+1];
		in=sc.next().toCharArray();
		for(int i=0;i<n;i++){
			Arrays.fill(cache[i], 987654321);
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i>=j) cache[i][j]=0;
			}
		}
		for(int i=n-2;i>=0;i--){
			for(int j=i+1;j<n;j++){
				if(in[i]!=in[j]){
					cache[i][j]=Math.min(cache[i][j], cache[i+1][j]+1);
					cache[i][j]=Math.min(cache[i][j], cache[i][j-1]+1);
				}else{
					cache[i][j]=Math.min(cache[i][j], cache[i+1][j-1]);
				}
			}
		}
		System.out.println(cache[0][n-1]);
	}
}
