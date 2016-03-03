/*
 * @(#)Problem1577_YG.java $version 2016. 3. 3.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.onedayonedp.d160302;

import java.util.Scanner;

public class Problem1577_YG {
	public static void main(String[] args){
		new Problem1577_YG().run();
	}
	
	int n;
	int m;
	long[][] cache;
	int k;
	int[] fx;
	int[] fy;
	int[] tx;
	int[] ty;
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt(); m=sc.nextInt(); k=sc.nextInt();
		cache=new long[n+2][m+2];
		fx = new int[k]; fy=new int[k]; tx=new int[k]; ty=new int[k];
		for(int i=0;i<k;i++){
			fx[i]=sc.nextInt()+1; fy[i]=sc.nextInt()+1; tx[i]=sc.nextInt()+1; ty[i]=sc.nextInt()+1;
		}
		
		cache[1][1]=1;
		for(int i=1;i<=n+1;i++){
			for(int j=1;j<=m+1;j++){
				if(i==1 && j==1) continue;
				if(canGo(i-1,j,i,j)) cache[i][j]+=cache[i-1][j];
				if(canGo(i,j-1,i,j)) cache[i][j]+=cache[i][j-1];	
			}
		}
		System.out.println(cache[n+1][m+1]);
	}
	
	public boolean canGo(int fx1, int fy1, int tx2, int ty2){
		boolean rst = true;
		for(int i=0;i<k;i++){
			if(fx[i]==fx1&&fy[i]==fy1&&tx[i]==tx2&&ty[i]==ty2 || fx[i]==tx2&&fy[i]==ty2&&tx[i]==fx1&&ty[i]==fy1){
				rst =false;
				break;
			}
		}
		return rst;
	}
}
