/*
 * @(#)Problem1707_YG.java $version 2016. 2. 14.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.backjoon.weeks2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1707_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem1707_YG().run();
	}
	
	int vs;
	int es;
	List<List<Integer>> g;
	int[] color;
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(br.readLine());
		
		while(cases-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			vs = Integer.valueOf(st.nextToken());
			es = Integer.valueOf(st.nextToken());
			
			color = new int[vs+1];
			g = new ArrayList<List<Integer>>();
			for(int i=0;i<=vs;i++) g.add(new ArrayList<Integer>());
			for(int i=0;i<es;i++){
				st = new StringTokenizer(br.readLine());
				int f = Integer.valueOf(st.nextToken());
				int t = Integer.valueOf(st.nextToken());
				
				
				g.get(f).add(t);
				g.get(t).add(f);
			}
			boolean rst = false;
			for(int i=1;i<=vs;i++){
				if(color[i] == 0){
					rst = dfs(i, 1);
					if(!rst) break;
				}
			}
			
			System.out.println(rst ? "YES" : "NO");
		}
	}
	
	public boolean dfs(int v, int c){
		color[v] = c;
		for(int elem : g.get(v)){
			if(color[elem] == 0){
				boolean rst = dfs(elem, 3-c);
				if(!rst) return rst;
			}else if(color[elem] == c){
				return false;
			}
		}
		return true;
	}
}
