/*
 * @(#)ProblemC.java $version 2016. 5. 28.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.codershigh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemC {
	public static void main(String[] args) throws IOException{
		new ProblemC().run();
	}
	
	boolean[] b=new boolean[1000001];
	int[] rule= new int[1000001];
	public void run() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c=Integer.valueOf(br.readLine());
		String[] in = br.readLine().split(" ");
	
		for(int i=1;i<=c;i++){
			if(i==Integer.valueOf(in[i-1])){
				System.out.println("-1");
				return;
			}
			rule[i]=Integer.valueOf(in[i-1]);
		}
		
		int[] cycleSize =new int[500001];
		int cycleCount=0;
		for(int i=1;i<=c;i++){
			if(!b[i]){
				b[i]=true;
				int cycleRst = findCycle(i,rule[i]);
				if(cycleRst!=-1){
					cycleCount+=1;
					cycleSize[cycleCount]=cycleRst;
				}
			}
		}
		
		boolean[] isSelect=new boolean[c+1];
		for(int i=1;i<=cycleCount;i++){
			int p=cycleSize[i];
			if(isSelect[p]) continue;
			for(int j=p;j<=c;j+=p){
				isSelect[j]=true;
			}
		}
		
		int rst=-1;
		for(int i=2;i<=c;i++){
			if(!isSelect[i]){
				rst=i;
				break;
			}
		}
		
		System.out.println(rst);
	}
	
	public int findCycle(int s, int now){
		if(s==now) return 1;
		if(b[now]) return -1;
		b[now]=true;
		return 1+findCycle(s,rule[now]);
	}
	
	public int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
