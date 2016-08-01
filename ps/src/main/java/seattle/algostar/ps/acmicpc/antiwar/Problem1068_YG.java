/*
 * @(#)Problem1068_YG.java $version 2016. 7. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.util.Scanner;

public class Problem1068_YG {
	public static void main(String[] args){
		new Problem1068_YG().run();
	}
	
	int[][] g;
	int n;
	int[] c;
	int[] visit;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		g=new int[n][n];
		c=new int[n]; visit=new int[n];
		int root=0;
		for(int i=0;i<n;i++){
			int parent=sc.nextInt();
			if(parent==-1){
				root=i;
			}else{
				g[parent][i]=1;
			}
		}
		dfs(root);
		int next=sc.nextInt();
		System.out.println(c[root]-c[next]);
	}
	
	public int dfs(int v){
		int rst=0;
		for(int i=0;i<n;i++){
			if(g[v][i] ==1 && visit[i]==0){
				visit[i]=0;
				rst+=dfs(i);
			}
		}
		
		rst=rst==0?1:rst;
		return c[v]=rst;
	}
}
