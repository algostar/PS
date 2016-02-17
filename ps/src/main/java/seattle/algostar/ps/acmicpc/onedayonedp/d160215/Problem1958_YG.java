/*
 * @(#)Problem1958_YG.java $version 2016. 2. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160215;

import java.util.Scanner;

public class Problem1958_YG {
	public static void main(String[] args){
		new Problem1958_YG().run();
	}
	
	char[] a;
	char[] b;
	char[] c;
	int[][][] cache;
	public void run(){
		Scanner sc = new Scanner(System.in);
		a=sc.next().toCharArray();
		b=sc.next().toCharArray();
		c=sc.next().toCharArray();
		cache = new int[a.length+1][b.length+1][c.length+1];
		
		for(int i=1;i<=a.length;i++){
			for(int j=1;j<=b.length;j++){
				for(int k=1;k<=c.length;k++){
					if((a[i-1] == b[j-1]) && (b[j-1] == c[k-1])){cache[i][j][k]=cache[i-1][j-1][k-1]+1;
					
					}else{
						int rst=0;
						if(i>0) rst = Math.max(rst, cache[i-1][j][k]);
						if(j>0) rst = Math.max(rst, cache[i][j-1][k]);
						if(k>0) rst = Math.max(rst, cache[i][j][k-1]);
						cache[i][j][k] = rst;
					}
				}
			}
		}
		
		System.out.println(cache[a.length][b.length][c.length]);
	}
}
