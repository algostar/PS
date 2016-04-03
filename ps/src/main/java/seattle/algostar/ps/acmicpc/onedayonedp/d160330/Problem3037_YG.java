/*
 * @(#)Problem3037_YG.java $version 2016. 3. 31.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.util.Scanner;

public class Problem3037_YG {
	public static void main(String[] args){
		new Problem3037_YG().run();
	}
	
	int[][] cache;
	int n;
	int c;
	public void run(){
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int c=sc.nextInt();
		cache= new int[n+1][c+1];
		cache[1][0]=1;
		for(int i=2;i<=n;i++){
			for(int j=0;j<=c;j++){
				cache[i][j]=cache[i-1][j];
				if(j>=1) cache[i][j]+=cache[i][j-1];
				cache[i][j]%=1000000007;
				if(j>=i) cache[i][j]-=cache[i-1][j-i];
				cache[i][j]=(cache[i][j]+1000000007)%1000000007;
			}
		}
		
		System.out.println(c==0?0:cache[n][c]);
	}
}
