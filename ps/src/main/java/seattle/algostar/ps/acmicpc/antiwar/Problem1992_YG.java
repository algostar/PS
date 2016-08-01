/*
 * @(#)Problem1992_YG.java $version 2016. 7. 6.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.util.Scanner;

public class Problem1992_YG {
	public static void main(String[] args){
		new Problem1992_YG().run();
	}
	
	int[][] a;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n][n];
		for(int i=0;i<n;i++){
			char[] input = sc.next().toCharArray();
			for(int j=0;j<n;j++){
				a[i][j]=input[j]-'0';
			}
		}
		f(0,0,n);
	}
	
	public void f(int x, int y, int size){
		if(size==1){ 
			System.out.print(a[x][y]);
			return;
		}
		int rst = canCompact(x,y,size);
		if(rst!=2){
			System.out.print(String.valueOf(rst));
		}else{
			System.out.print("(");
			int divideSize = size/2;
			f(x,y,divideSize);
			f(x,y+divideSize,divideSize);
			f(x+divideSize,y,divideSize);
			f(x+divideSize,y+divideSize,divideSize);
			System.out.print(")");
		}
	}
	
	// 압축가능할때 0,1 불가능시 2
	public int canCompact(int x, int y, int size){
		int d=a[x][y];
		for(int i=x;i<x+size;i++){
			for(int j=y;j<y+size;j++){
				if(d!=a[i][j]){
					d=2;
					break;
				}
			}
		}
		return d;
	}
}
