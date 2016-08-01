/*
 * @(#)Problem1074.java $version 2016. 6. 28.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.util.Scanner;

public class Problem1074_YG {
	public static void main(String[] args){
		new Problem1074_YG().run();
	}
	
	int n,r,c;

	public void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int a=sc.nextInt(); n=1;
			for(int i=0;i<a;i++){
				n*=2;
			}
			r=sc.nextInt();
			c=sc.nextInt();
			int rst = f(0,0,n);
			System.out.println(rst);
		}
	}
	
	public int f(int x, int y, int size){
		if(size==1) return 0;	
		int s = size/2;
		if(c<x+s && r<y+s) return f(x,y,s); 
		if(r<y) return f(x,y+s,s) + s*s;
		if(c<x) return f(x+s,y,s) + 2*s*s;
		return f(x+s,y+s,s) + 3*s*s;
	}
}
