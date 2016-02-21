/*
 * @(#)Problem10573_YG.java $version 2016. 2. 20.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.util.Scanner;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Problem10573_YG {
	public static void main(String[] args){
		new Problem10573_YG().run();
	}
	
	long[][][] cache;	
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		cache = new long[81][10][10];
		long[][] ncache = new long[81][10];
		for(int i=0;i<=9;i++) cache[0][i][i]=1;
		for(int i=1;i<=80;i++){
			for(int j=1;j<=9;j++){
				for(int k=j;k<=9;k++){
					for(int m=j;m<=k;m++){
						cache[i][j][k] += cache[i-1][j][m];
					}
				}
			}
		}
		
		for(int i=0;i<=80;i++){
			for(int j=1;j<=9;j++){
				for(int k=1;k<=9;k++){
					ncache[i][j] += cache[i][j][k];
				}
				System.out.println(i + " " + j + " " + ncache[i][j]);
			}
		}
	
		
//		for(int r=0;r<n;r++){
//			char[] in = sc.next().toCharArray();
//			int size = in.length;
//			long rst=0;
//			if(isAsc(in)){
//				for(int i=0;i<size;i++){
//					int v = in[i] - '0';
//					
//					rst += ncache[size-i-1][0];
//					for(int j=1;j<v;j++){
//						rst += ncache[size-i][j];
//					}
//				}
//				System.out.println(rst);
//			}else{
//				System.out.println(-1);
//			}
//		}
//		
	}
	
	public boolean isAsc(char[] a){
		int prev=-1;
		boolean isAscNum=true;
		for(int i=0;i<a.length;i++){
			int now = a[i] - '0';
			if(prev>now){
				isAscNum=false;
				break;
			}
			prev=now;
		}
		return isAscNum;
	}
}
