/*
 * @(#)PermTopDown.java $version 2016. 1. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.algorithm;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class PermTopDown {
	int[] A = {1, 2, 3, 4};
	
	public static void main(String[] args){
		new PermTopDown().run();
	}
	
	public void run(){
		f(0,new int[4]);
	}
	
	public void f(int idx, int[] a){
		if(idx >= 4){
			for(int i=0;i<4;i++){
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}
		a[idx] = A[idx];
		f(idx+1,a);
		for(int i=0;i<idx;i++){
			swap(a,i,idx);
			f(idx+1,a);
			swap(a,i,idx);
		}
	}
	
	public void swap(int[] d, int a, int b){
		int temp = d[a];
		d[a]=d[b]; d[b]=temp;
	}
}
