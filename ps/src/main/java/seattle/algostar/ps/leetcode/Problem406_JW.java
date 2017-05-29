package seattle.algostar.ps.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Problem406_JW {
	public static void main(String[] args) {
		new Problem406_JW().solve();
	}

	private void solve() {
		int[][] people= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(Arrays.deepToString(reconstructQueue(people)));;
	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				return p1[0] != p2[0] ? Integer.compare(p2[0], p1[0]) : Integer.compare(p1[1], p2[1]);
			}
		});
		List<int[]> list = new LinkedList<int[]>();
		for (int[] ppl : people)
			list.add(ppl[1], ppl);
		return list.toArray(new int[people.length][]);
	}

	public int[][] reconstructQueue2(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int diff = o1[1] - o2[1];
				if (diff == 0)
					return o1[0] - o2[0];
				else
					return diff;
			}
		});

		int[][] res = new int[people.length][2];
		for (int i = 0; i < people.length; i++) {
		}

		return null;
	}
}
