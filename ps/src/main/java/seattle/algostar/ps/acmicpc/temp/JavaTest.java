/*
 * @(#)JavaTest.java $version 2016. 8. 4.
 *
 * Copyright 2014 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package seattle.algostar.ps.acmicpc.temp;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author 쇼핑관리개발팀 정용균
 */
public class JavaTest {
	public static void main(String[] args){
		new JavaTest().run();
	}
	
	public void run(){
		String string = "한글";  
		for (int i = 0; i < string.length(); i++) {  
		    System.out.print(String.format("U+%04X ", string.codePointAt(i)));
		}
//		System.out.println();  
//		System.out.println(Charset.defaultCharset().name());
//		System.out.println(Arrays.toString("a".getBytes()));
//		String k;
//		byte k;
	
//		Byte c=1;
//		System.out.println(c.SIZE);
		
//		Character a = 'a';
//		System.out.println(a.SIZE);
//
//		
		String b="한";
		System.out.println(Arrays.toString(b.getBytes()));

	}
}
