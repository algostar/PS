package seattle.algostar.ps.acmicpc.support;

import java.io.*;
import java.util.*;

public class RandomTester {
	public static void main(String[] args) {
		new RandomTester().printTestCase();
	}

	private void printTestCase() {
		int testCasesCnt = 10;
		// n, m .. 변수 갯수
		int ARRAY_COUNT = 2;
		
		int cntStart = 1;
		int cntEnd = 10;
		
		int valueStart = 1;
		int valueEnd = 100;
		
		for (int t = 0; t < testCasesCnt; t++) {
			int[] arrayCnts = new int[ARRAY_COUNT];
			int[][] arrayValue = new int[ARRAY_COUNT][];
			for (int i =0 ; i < ARRAY_COUNT; i++) {
				arrayCnts[i] = new Random().nextInt(cntEnd) + cntStart;
				int[] array = new int[arrayCnts[i]];
				for (int j = 0; j < array.length; j++) {
					array[j] = new Random().nextInt(valueEnd) + valueStart;
				}
				arrayValue[i] = array;
			}
			
			// print
			for (int i = 0; i < ARRAY_COUNT; i++) {
				if (i != ARRAY_COUNT -1) {
					System.out.print(arrayCnts[i] + " ");
				} else {
					System.out.println(arrayCnts[i]);
				}
			}
			
			for (int i = 0; i < ARRAY_COUNT; i++) {
				int[] array = arrayValue[i];
				for (int j = 0; j < array.length; j++) {
					if (j != array.length - 1) {
						System.out.print(array[j] + " ");
					} else {
						System.out.println(array[j]);
					}
				}
			}
		}
	}
}
