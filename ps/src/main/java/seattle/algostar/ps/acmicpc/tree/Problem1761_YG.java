/*
 * @(#)Problem1761_YG.java $version 2016. 6. 16.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Problem1761_YG {
	public static void main(String[] args) throws NumberFormatException, IOException{
		new Problem1761_YG().run();
	}
	
	int n;
	Tree[] parent;
	List<List<Tree>> t;
	
	public void run() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(br.readLine()!=null){
			n=Integer.valueOf(br.readLine());
			t=new ArrayList<List<Tree>>();
			for(int i=0;i<=n;i++){
				t.add(new ArrayList<Tree>());
			}
			parent = new Tree[n+1];
		}

		
	}
	
	int depth(int v){
		return 0;
	}
	
	int getDistance(int a, int ad, int b, int bd){
		if(ad==bd) return 0;
		if(ad>bd){
			return parent[a].weight+getDistance(parent[a].v,ad-1,b,bd);
		}else if(ad<bd){
			return parent[b].weight+getDistance(a,ad,parent[b].v,bd-1);
		}
		return parent[a].weight+parent[b].weight+getDistance(parent[a].v,ad-1,parent[b].v,bd-1);
	}
	
	public class Tree{
		int v;
		int parent;
		int weight;
		
		Tree(int v, int parent, int weight){
			this.v=v;
			this.parent=parent;
			this.weight=weight;
		}
	}
}
