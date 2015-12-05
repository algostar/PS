/*
 * @(#)Problem2666.java $version 2015. 12. 5.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.dfs;

import java.util.Scanner;

public class Problem2666 {
	public static void main(String[] args){
		new Problem2666().run();
	}
	
	int[] a;
	int n;
	public void run(){
		Scanner sc = new Scanner(System.in);
		sc.nextInt();

		int startx = sc.nextInt(); int starty = sc.nextInt();
		n = sc.nextInt();
		a = new int[n +1];
		for(int i =1;i<=n;i++){
			a[i] = sc.nextInt();
		}
		
		System.out.println(f(1, startx, starty));
	}
	
	public int f(int idx, int x, int y){
		if(idx > n) return 0;
		if(a[idx] == x || a[idx] == y) return f(idx+1, x, y);
		if(a[idx] > x && a[idx] < y){
			return Math.min(f(idx+1, a[idx], y) + a[idx] - x, f(idx+1,x,a[idx]) + y - a[idx]);
		}
		
		if(a[idx] < x){
			return f(idx + 1, a[idx], y) + x - a[idx];
		}else{
			return f(idx + 1, x, a[idx]) + a[idx] - y;
		}
	}
}
