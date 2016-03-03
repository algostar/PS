/*
 * @(#)Problem2092_YG.java $version 2016. 3. 3.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.Scanner;

public class Problem2092_YG {
	public static void main(String[] args){
		new Problem2092_YG().run();
	}
	
	int t,a,s,b;
	int[][] cache;
	int[] c;
	public void run(){
		Scanner sc = new Scanner(System.in);
		t=sc.nextInt(); a=sc.nextInt(); s=sc.nextInt(); b=sc.nextInt();
		c = new int[t+1];
		cache = new int[t+1][b+1];
		for(int i=0;i<a;i++){
			c[sc.nextInt()]++;
		}
		
		cache[0][0]=1;
		for(int i=1;i<=t;i++){
			for(int j=0;j<=b;j++){
				for(int k=0;k<=Math.min(c[i], j);k++){
					if(j-k>=0){
						cache[i][j]+=cache[i-1][j-k];
						cache[i][j]%=1000000;
					}
				}
			}
		}
		int rst=0;
		for(int i=s;i<=b;i++){
			rst+=cache[t][i];
			rst%=1000000;
		}
		System.out.println(rst);
	}
}
