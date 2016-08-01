/*
 * @(#)Problem2644_YG.java $version 2016. 7. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.util.Scanner;

public class Problem2644_YG {
	public static void main(String[] args){
		new Problem2644_YG().run();
	}
	
	int[][] g;
	int[] visit;
	int rx;
	int rst=-1; int n;
	int start;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		visit=new int[n+1]; g=new int[n+1][n+1];
		start=sc.nextInt(); rx=sc.nextInt();
		int m=sc.nextInt();
		for(int i=0;i<m;i++){
			int from=sc.nextInt(); int to=sc.nextInt();
			g[from][to]=1;g[to][from]=1;
		}
		dfs(start,0);
		System.out.println(rst);
	}
	
	public void dfs(int x, int s){
		if(x==rx){
			rst=s; return;
		}
		visit[x]=1;
		
		for(int i=1;i<=n;i++){
			if(g[x][i]==1 && visit[i]==0){
				dfs(i,s+1);
			}
		}
	}
}
