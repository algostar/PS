/*
 * @(#)Problem1994_YG.java $version 2016. 4. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1994_YG {
	public static void main(String[] args){
		new Problem1994_YG().run();
	}
	
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	int[][] cache;
	int n;
	int[] a;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		cache= new int[n+1][n+1];
		a=new int[n+1];
		for(int i=1;i<=n;i++){
			a[i]=sc.nextInt();
		}
		Arrays.sort(a);
		a[0]=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			m.put(a[i], i);
		}
		
		int rst=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<i;j++){
				int dist=a[i]-a[j];
				if(dist==0){
					cache[i][j]=i-j+1;
					rst=Math.max(rst, cache[i][j]);
					continue;
				}

				if(m.containsKey(a[j]-dist) && j> m.get(a[j]-dist)){		
					cache[i][j]=cache[j][m.get(a[j]-dist)]+1;
				}else{
					cache[i][j]=2;
				}
				rst=Math.max(rst, cache[i][j]);
			}
		}
		System.out.println(rst);
	}
}
