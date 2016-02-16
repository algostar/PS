/*
 * @(#)Problem11725_YG.java $version 2016. 2. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem11725_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem11725_YG().run();
	}
	
	int n;
	List<List<Integer>> tree = new ArrayList<List<Integer>>();
	int[] parent;
	int[] visit;
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.valueOf(br.readLine());
		parent = new int[n+1];
		visit = new int[n+1];
		for(int i=0;i<=n;i++) tree.add(new ArrayList<Integer>());
		for(int i=1;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int f = Integer.valueOf(st.nextToken());
			int t = Integer.valueOf(st.nextToken());
			tree.get(f).add(t);
			tree.get(t).add(f);
		}
		
		dfs(1);
		for(int i=2;i<=n;i++){
			bw.write(String.valueOf(parent[i]));
			bw.newLine();
		}
		bw.flush();
	}
	
	public void dfs(int v){
		visit[v] =1;
		for(int elem : tree.get(v)){
			if(visit[elem] == 0){
				parent[elem] = v;
				dfs(elem);
			}
		}
	}
}
