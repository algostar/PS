package seattle.algostar.ps.acmicpc.dp;

import java.io.*;
import java.util.*;

public class Problem2258_JW {

	public static void main(String[] args) throws IOException {
		new Problem2258_JW().run();
	}

	int N, M;
	Meat[] meats;
	int[] wsum;
	int[] psum;

	private void run() throws IOException {
		R.init(System.in);
		N = R.nextInt();
		M = R.nextInt();
		meats = new Meat[N];
		for (int i = 0; i < N; i++) {
			meats[i] = new Meat(R.nextInt(), R.nextInt());
		}
		Arrays.sort(meats);
		wsum = new int[N];
		psum = new int[N];
		wsum[0] = meats[0].weight;
		psum[0] = meats[0].price;
		for (int i = 1; i < N; i++) {
			wsum[i] = wsum[i - 1] + meats[i].weight;
			if (meats[i - 1].price  == meats[i].price) {
				psum[i] = meats[i].price + psum[i - 1];
			} else {
				psum[i] = meats[i].price;
			}
		}

		int minPrice = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (wsum[i] >= M) {
				minPrice = Math.min(minPrice, psum[i]);
			}
		}

		if (minPrice == Integer.MAX_VALUE)
			minPrice = -1;
		System.out.println(minPrice);
	}

	class Meat implements Comparable<Meat> {
		int weight;
		int price;

		public Meat(int w, int p) {
			this.weight = w;
			this.price = p;
		}

		public int compareTo(Meat o) {
			int r = this.price - o.price;
			if (r == 0) {
				r = -(this.weight - o.weight);
			}
			return r;
		}
	}
	static class R {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}
