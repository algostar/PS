/*
 * @(#)CountingSheep.java $version 2016. 4. 9.
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

public class CountingSheep {
	public static void main(String args[]) throws Exception {
		new CountingSheep().run();
	}
	
	long n;
	boolean[] check;
	public void run() throws Exception {
		Scanner sc = new Scanner(new FileInputStream(new File("C:\\codejam\\2016\\q2_large.txt")));
		PrintWriter out = new PrintWriter(new FileOutputStream("C:\\codejam\\2016\\q2_large_out.txt"));
		
		int cases = sc.nextInt();
		int size=cases;

		while (cases-- > 0) {
			check=new boolean[10];
			n = sc.nextLong();
			
			if(n==0){
				out.println("Case #" + String.valueOf(size - cases) + ": " + "INSOMNIA");
			}else{
				out.println("Case #" + String.valueOf(size - cases) + ": " + Answer(n));
			}
			out.flush();
		}
		out.close();
		System.out.println("===end==");
	}

	public long Answer(long k) {
		long rst=0;
		long s=k;
		while(true){
			f(k);
			rst=k;
			if(allCheck())break;
			k+=s;
		}
		return rst;
	}
	
	public void f(long r){
		while(true){
			if(r<=0) break;
			check[(int)(r%10)]=true;
			r/=10;
		}
	}
	public boolean allCheck(){
		for(int i=0;i<10;i++){
			if(!check[i]){
				return false;
			}
		}
		return true;
	}
}
