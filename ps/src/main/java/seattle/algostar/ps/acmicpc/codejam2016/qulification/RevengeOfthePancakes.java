/*
 * @(#)RevengeOfthePancakes.java $version 2016. 4. 9.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.codejam2016.qulification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class RevengeOfthePancakes {
	public static void main(String args[]) throws Exception {
		new RevengeOfthePancakes().run();
	}

	int[] d;
	int n;
	int[][] cache;

	public void run() throws Exception {
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream(new File("C:\\codejam\\2016\\q1.txt")));
		PrintWriter out = new PrintWriter(new FileOutputStream("C:\\codejam\\2016\\q1_out.txt"));
		int cases = sc.nextInt();
		int size = cases;

		while (cases-- > 0) {
			char[] in=sc.next().toCharArray();
			n=in.length;
			d=new int[n];
			cache= new int[n][10000];
			for(int i=0;i<n;i++){
				if(in[i]=='-'){
					d[i]=0;
				}else{
					d[i]=1;
				}
			}
			//System.out.println(f(0, d));
			out.println("Case #" + String.valueOf(size - cases) + ": " + f(0, d));
			out.flush();
		}
		out.close();
		System.out.println("===end==");
	}
	
	public int f(int idx, int[] des){
		if(isComplete(des)){
			return 0;
		}
		if(idx>=n) return 987654321;
		
		int v=0; int base=1;
		for(int i=0;i<n;i++){
			if(des[i]==1){
				v+=base;
			}
			base*=2;
		}
		if(cache[idx][v]!=0){
			return cache[idx][v];
		}
		
		int rst=987654321;
		for(int i=0;i<n;i++){
			reverse(des,i);
			rst=Math.min(rst, f(idx+1,des)+1);
			reverse(des,i);
		}
		return cache[idx][v]=rst;
	}
	
	public boolean isComplete(int[] des){
		boolean rst=true;
		for(int i=0;i<n;i++){
			if(des[i]==0){
				rst=false;
				break;
			}
		}
		return rst;
	}
	
	public void reverse(int[] des, int e){
		for(int i=0;i<=e;i++){
			des[i]=1-des[i];
		}
		int mid=e/2; 
		for(int i=0;i<=mid;i++){
			int temp=des[i];
			des[i]=des[e-i];
			des[e-i]=temp;
		}
	}
}
