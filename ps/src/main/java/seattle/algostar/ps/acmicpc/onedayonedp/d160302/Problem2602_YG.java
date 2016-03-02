/*
 * @(#)Problem2602_YG.java $version 2016. 3. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem2602_YG {
	public static void main(String[] args){
		new Problem2602_YG().run();
	}
	
	char[] a;
	char[] b;
	char[] c;
	int[][][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		char[] aa=sc.next().toCharArray();
		char[] bb=sc.next().toCharArray();
		char[] cc=sc.next().toCharArray();
		
		cache= new int[a.length+1][c.length+1][2];
		cache[0][0][0]=1; cache[0][0][1]=1;
		
		int rst=0;
		for(int i=1;i<=a.length;i++){
			for(int j=1;j<=c.length;j++){
				for(int k=1;k<i;k++){
					if(b[k]==c[j-1]){
						cache[i][j][0]+=cache[k][j-1][1];
					}
					
					if(a[k]==c[j-1]){
						cache[i][j][1]+=cache[k][j-1][0];
					}
				}
				if(j==3) rst+=cache[i][j][0]+cache[i][j][1];
			}
		}
		System.out.println(rst);
	}
}
