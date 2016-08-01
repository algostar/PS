/*
 * @(#)ProblemB.java $version 2016. 5. 28.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.codershigh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args){
		new ProblemB().run();
	}
	
	Map<String, List<String>> m =new HashMap<String, List<String>>();
	public void run(){
		m.put("1967", new LinkedList<String>(Arrays.asList("DavidBowie")));
		m.put("1969", new LinkedList<String>(Arrays.asList("SpaceOddity")));
		m.put("1970", new LinkedList<String>(Arrays.asList("TheManWhoSoldTheWorld")));
		m.put("1971", new LinkedList<String>(Arrays.asList("HunkyDory")));
		m.put("1972", new LinkedList<String>(Arrays.asList("TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars")));
		m.put("1973", new LinkedList<String>(Arrays.asList("AladdinSane","PinUps")));
		m.put("1974", new LinkedList<String>(Arrays.asList("DiamondDogs")));
		m.put("1975", new LinkedList<String>(Arrays.asList("YoungAmericans")));
		m.put("1976", new LinkedList<String>(Arrays.asList("StationToStation")));
		m.put("1977", new LinkedList<String>(Arrays.asList("Low","Heroes")));
		m.put("1979", new LinkedList<String>(Arrays.asList("Lodger")));
		m.put("1980", new LinkedList<String>(Arrays.asList("ScaryMonstersAndSuperCreeps")));
		m.put("1983", new LinkedList<String>(Arrays.asList("LetsDance")));
		m.put("1984", new LinkedList<String>(Arrays.asList("Tonight")));
		m.put("1987", new LinkedList<String>(Arrays.asList("NeverLetMeDown")));
		m.put("1993", new LinkedList<String>(Arrays.asList("BlackTieWhiteNoise")));
		m.put("1995", new LinkedList<String>(Arrays.asList("1.Outside")));
		m.put("1997", new LinkedList<String>(Arrays.asList("Earthling")));
		m.put("1999", new LinkedList<String>(Arrays.asList("Hours")));
		m.put("2002", new LinkedList<String>(Arrays.asList("Heathen")));
		m.put("2003", new LinkedList<String>(Arrays.asList("Reality")));
		m.put("2013", new LinkedList<String>(Arrays.asList("TheNextDay")));
		m.put("2016", new LinkedList<String>(Arrays.asList("BlackStar")));
		
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		while(cases-->0){
			int tc=0;
			int s=sc.nextInt();	 int e=sc.nextInt(); List<String> rst=new LinkedList<String>();
			for(int i=s;i<=e;i++){
				if(m.containsKey(String.valueOf(i))){
					List<String> elem = m.get(String.valueOf(i));
					tc+=elem.size();
					for(String el:elem){
						rst.add(i + " " + el);
					}
				}
			}
			
			System.out.println(tc);
			for(String rs:rst){
				System.out.println(rs);
			}
		}
		
	}
}
