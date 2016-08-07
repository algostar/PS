package seattle.algostar.ps.acmicpc.elementry.sido.si2004;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem2607_JW {
	public static void main(String[] args) {
		new Problem2607_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int nn = sc.nextInt();
		String[] A = new String[nn];
		for (int i = 0; i < nn; i++) {
			A[i] = sc.next();
		}
		int totalCnt = 0;
		Map<Character, Integer> charMap = getCharMap(A[0]);
		for (int i = 1; i < nn; i++) {
			int diff = getDiffCnt(charMap, A[i]);
			if (diff <= 1) {
				totalCnt++;
			}
		}
		System.out.println(totalCnt);
	}

	private int getDiffCnt(Map<Character, Integer> charMap, String compareWord) {
		Map<Character, Integer> compareCharMap = getCharMap(compareWord);
		
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			if (compareCharMap.containsKey(entry.getKey())) {
				int compareCharValue = compareCharMap.get(entry.getKey());
				compareCharMap.put(entry.getKey(), Math.abs(entry.getValue() - compareCharValue));
			} 
		}
		
		int diffCnt = 0;
		for (Map.Entry<Character, Integer> entry : compareCharMap.entrySet()) {
			diffCnt += entry.getValue();
		}
		
		return diffCnt;
	}

	private Map<Character, Integer> getCharMap(String word) {
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (char ch : word.toCharArray()) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		return charMap;
	}
}
