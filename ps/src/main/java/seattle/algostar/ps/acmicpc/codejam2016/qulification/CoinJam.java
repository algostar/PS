/*
 * @(#)CoinJam.java $version 2016. 4. 9.
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

public class CoinJam {
	public static void main(String args[]) throws Exception {
		new CoinJam().run();
	}
	
	int n;
	int	k;
	int count=0;
	boolean[] visit = new boolean[20000];
	Scanner sc;
	PrintWriter out;
	
	public void run() throws Exception {
		//Scanner sc = new Scanner(System.in);
		
		sc = new Scanner(new FileInputStream(new File("C:\\codejam\\2016\\q4.txt")));
		out = new PrintWriter(new FileOutputStream("C:\\codejam\\2016\\q4_out.txt"));
		sc.nextInt();
		n=sc.nextInt();
		k=sc.nextInt();
		out.println("Case #1:");
		f(0,new int[n-2]);
		out.flush();
		out.close();
		System.out.println("===end==");
	}
	
	public void f(int idx, int[] d){
		if(count>=k) return;
		if(idx==n-2){
			boolean rst=true;
			long[] rstv=new long[9];
			for(int base=2;base<=10;base++){
				long v=1; long p=base;
				for(int i=n-3;i>=0;i--){
					v+=d[i]*p;
					p*=base;
				}
				v+=p;
				long div=divide(v);
				if(div==-1){
					rst=false;
					break;
				}else{
					rstv[base-2]=div;
				}
			}
			if(rst){
				count++;
				out.print("1");
				for(int i=0;i<n-2;i++){
					out.print(d[i]);
				}
				out.print("1");
				out.print(" ");
				
				for(int j=0;j<9;j++){
					out.print(rstv[j] + " ");
				}
				out.println();
			}
			return;
		}
		
		f(idx+1, d);
		d[idx]=1;
		f(idx+1, d);
		d[idx]=0;
	}
	
	public long divide(long a){
		for(long i=2;i*i<=a;i++){
			if(a%i == 0){
				return i;
			}
		}
		return -1;
	}
}
