package seattle.algostar.ps.acmicpc.onedayonedp.d160223;

import java.util.Arrays;
import java.util.Scanner;

public class Problem2515_JW {
	public static void main(String[] args) {
		new Problem2515_JW().solve();
	}

	private void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		Pic[] pics = new Pic[n+1];
		int[] C = new int[n+1];
		pics[0] = new Pic(0, 0);
		for (int i = 1; i <= n; i++) {
			pics[i] = new Pic(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(pics);
		
		int[] MAX = new int[n+1];
		int[] IDX = new int[n+1];
		for (int i = 1; i <= n; i++) {
			for (IDX[i] = IDX[i-1] + 1; IDX[i] < i; IDX[i]++) { 
				if (pics[i].height - pics[IDX[i]].height < s) break;
			}
			IDX[i]--;
			
			C[i] = MAX[IDX[i]] + pics[i].cost;
			MAX[i] = Math.max(C[i], MAX[i-1]);
		}
		
		System.out.println(MAX[n]);
	}
	
	class Pic implements Comparable<Pic>{
		int height;
		int cost;
		public Pic(int h, int c) {
			this.height = h;
			this.cost = c;
		}
		@Override
		public int compareTo(Pic o) {
			return this.height - o.height;
		}
	}
}
