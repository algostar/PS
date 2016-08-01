/*
 * @(#)Problem1761_YG.java $version 2016. 7. 7.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.antiwar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1761_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem1761_YG().run();
	}
	
	List<List<Tree>> g;
	int[] visit;
	int dest;
	int n; int m;
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.valueOf(br.readLine());
		visit=new int[n+1];
		g=new ArrayList<List<Tree>>();
		for(int i=0;i<n+1;i++){
			g.add(new ArrayList<Tree>());
		}
		for(int i=1;i<n;i++){
			String[] in = br.readLine().split(" ");
			int from = Integer.valueOf(in[0]); int to = Integer.valueOf(in[1]); int value=Integer.valueOf(in[2]);
			g.get(from).add(new Tree(to,value));
			g.get(to).add(new Tree(from,value));
		}
		m=Integer.valueOf(br.readLine());
		for(int i=0;i<m;i++){
			Arrays.fill(visit, 0);
			String[] in = br.readLine().split(" ");
			int from = Integer.valueOf(in[0]); dest = Integer.valueOf(in[1]);
			visit[from]=1;
			System.out.println(dfs(from,0));
		}
	}
	
	public int dfs(int v,int dist){
		if(v==dest) return dist;
		int rst=0;
		for(Tree elem : g.get(v)){
			if(visit[elem.v]==0){
				visit[elem.v]=1;
				rst+=dfs(elem.v,dist+elem.w);
			}
		}
		return rst;
	}
	
	public class Tree{
		int v;
		int w;
		public Tree(int v, int w){
			this.v=v; this.w=w;
		}
	}
}
