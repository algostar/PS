/*
 * @(#)Problem11557.java $version 2015. 12. 3.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem11557 {
	public static void main(String[] args){
		new Problem11557().run();
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while(cases-- > 0){
			int n = sc.nextInt();
			List<School> list = new ArrayList<School>();
			
			for(int i = 0; i < n; i++){
				list.add(new School(sc.next(), sc.nextInt()));
			}
			
			Collections.sort(list);
			System.out.println(list.get(0).name);
		}
	}
	
	class School implements Comparable<School>{
		String name;
		int value;
		
		public School(String name, int value){
			this.name = name;
			this.value = value;
		}

		/**
		 * @param o
		 * @return
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		@Override
		public int compareTo(School o) {
			return this.value < o.value ? 1 : -1;
		}
	}
}
