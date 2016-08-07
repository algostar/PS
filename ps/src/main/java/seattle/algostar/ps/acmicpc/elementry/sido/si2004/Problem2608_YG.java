/*
 * @(#)Problem2608_YG.java $version 2016. 8. 2.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2608_YG {
	public static void main(String[] args){
		new Problem2608_YG().run();
	}
	
	Map<String, Integer> km = new HashMap<String, Integer>(){
		{
			put("I",1); put("V",5); put("X",10); put("L",50); put("C",100); put("D",500);  put("M",1000); 
			put("IV",4); put("IX",9); put("XL",40); put("XC",90); put("CD",400); put("CM",900);
		}
	};
	
	Map<Integer, String> vm = new LinkedHashMap<Integer, String>(){
		{
			put(1000, "M"); put(900, "CM"); put(500, "D"); put(400, "CD"); put(100, "C"); put(90, "XC");
			put(50, "L"); put(40, "XL"); put(10, "X"); put(9, "IX"); put(5, "V"); put(4, "IV"); put(1, "I");
		}
	};
	
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		String in1 = sc.next();
		String in2 = sc.next();
		

		int rst = encode(in1)+encode(in2);
		System.out.println(rst);
		System.out.println(decode(rst));
	}
	
	int encode(String e){
		int rst=0;
		for(int i=0;i<e.length();){
			if(i!=e.length()-1 && km.containsKey(e.subSequence(i, i+2))){
				rst+=km.get(e.subSequence(i, i+2));
				i+=2;
			}else{
				rst+=km.get(e.subSequence(i, i+1));
				i++;
			}
		}
		return rst;
	}
	
	String decode(int d){
		String rst="";
		while(d>0){
			for(int elem:vm.keySet()){
				if(d-elem>=0){
					d-=elem;
					rst+=vm.get(elem);
					break;
				}
			}
		}
		return rst;
	}
}
