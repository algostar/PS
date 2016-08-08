package seattle.algostar.ps.acmicpc.temp;

import java.io.*;
import java.util.*;
 
public class Test1 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String a = "한";
		System.out.println(a.getBytes("ISO-8859-1").length);
		
		String c = "1";
		System.out.println(c.getBytes().length);
		
		Character b = '가';
		
		System.out.println(Integer.toHexString(b));
	}
}