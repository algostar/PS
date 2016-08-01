/*
 * @(#)QuickSort.java $version 2016. 6. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class QuickSort {
	public static void main(String[] args){
		new QuickSort().run();
	}
	
	// 12개의 input
	int[] a = {2,1};
	public void run(){
		this.quick(0, 1);
		for(int i=0;i<2;i++){
			System.out.println(a[i] + " ");
		}
	}
	
	public void quick(int s, int e){
		if(s<e){
			int p=s;
			int l=s+1;
			int r=e;
			
			while(l<=r){
				while(l<=e && a[p]>=a[l]) l++;
				while(r>p && a[p]<=a[r]) r--;
				if(l<r){
					int temp=a[l];
					a[l]=a[r];
					a[r]=temp;
				}
			}
			
			int temp=a[r];
			a[r]=a[p];
			a[p]=temp;
			quick(s,r-1);
			quick(r+1,e);
		}
	}
}
