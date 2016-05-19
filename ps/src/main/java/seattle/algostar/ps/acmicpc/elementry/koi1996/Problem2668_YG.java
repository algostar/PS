/*
 * @(#)Problem2668_YG.java $version 2016. 4. 30.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.koi1996;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem2668_YG {
	public static void main(String[] args){
		new Problem2668_YG().run();
	}
	
	int[] in;
	int n;
	int[] visit;
	List<Integer> rst = new ArrayList<Integer>();
	int[] select;
	public void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		in = new int[n+1]; visit=new int[n+1]; select = new int[n+1];
		for(int i=1;i<=n;i++){
			in[i]=sc.nextInt();
		}
		List<Integer> rst = new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			List<Integer> t = getCycle(i);
			if(t != null){
				for(int elem:t){
					if(select[elem]==0){
						rst.add(elem);
						select[elem]=1;
					}
				}
			}
		}
		Collections.sort(rst);
		System.out.println(rst.size());
		for(int i=0;i<rst.size();i++){
			System.out.println(rst.get(i));
		}
	}
	
	List<Integer> getCycle(int s){
		Arrays.fill(visit, 0);
		int e=s;
		List<Integer> r = new ArrayList<Integer>();
		boolean isRst = false;
		while(true){
			e=in[e];
			r.add(e);
			if(visit[e]>0){
				isRst=false; break;
			}
			if(s==in[e]){
				isRst=true; break;
			}
			visit[e]++;
		}
		
		if(isRst){
			return r;
		}else{
			return null;
		}
	}
}
