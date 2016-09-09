package seattle.algostar.ps.acmicpc.dp;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while (sc.hasNext()) {
			char[] text = sc.nextLine().toCharArray();
			
			String res = "";
			for (int i = 0; i < text.length; i++) {
				if (text[i] == '_') {
					res += Character.toUpperCase(text[i+1]);
					i++;
				} else {
					res += text[i];
				}
			}
			
			System.out.println(res);
		}
		
	}
}
