package seattle.algostar.ps.acmicpc.onedayonedp.d160330;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9327_JW2 {
	public static void main(String[] args) throws IOException {
		new Problem9327_JW2().solve(); 
	}

	private void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tt = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < tt; t++) {
			st = new StringTokenizer(br.readLine());
			int nn = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int sum = 0;
			int[] V = new int[nn];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < nn; i++) {
				V[i] = Integer.parseInt(st.nextToken());
				sum += V[i];
			}
			
			int max = 4000*100;
			boolean[] F = new boolean[max + 1];
			F[0] = true;
			for (int i = 0; i < nn; i++) {
				for (int s = sum * 2; s >= 0; s--) {
					if (F[s]) {
						F[s + 2*V[i]] = true;
					} 
				}
			}
			boolean found = false;
			for (int s = e; s <= max; s++) {
				if (F[s]) {
					System.out.println(s/2);
					found = true;
					break;
				}
			}
			
			if (!found) System.out.println("FULL");
		}
	}
}
