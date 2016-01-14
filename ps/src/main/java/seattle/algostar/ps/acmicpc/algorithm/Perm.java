/*
 * @(#)Perm.java $version 2016. 1. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.algorithm;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class Perm {
	int[] A = {1, 2, 3, 4};
	
	public static void main(String[] args){
		new Perm().run();
	}
	
	public void run(){
		f(new int[4], new int[4], 0);
	}
	
	public void f(int[] v, int[] r, int idx){
		if(idx >= 4){
			for(int i=0;i<4;i++){
				System.out.print(r[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<4;i++){
			if(v[i] == 0){
				v[i] = 1; r[idx]=A[i];
				f(v,r,idx+1);
				v[i] = 0;
			}
		}
	}
}
