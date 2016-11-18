package seattle.algostar.ps.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem397_JW {
	public static void main(String[] args) {
		new Problem397_JW().solve();
	}

	private void solve() {
//		System.out.println(integerReplacement(2147483647));
		System.out.println(count(Long.MAX_VALUE));
	}
	
	
    private int count(long n) {
        if (n == 1) return 0;
        int cnt = 0;
        if (n % 2 == 0) { cnt += count(n/2) + 1; }
        else {
            cnt = count(n+1) + 1;
            cnt = Math.min(cnt, count(n-1) + 1);
        }
        return cnt;
    }
	
	
	class Number {
		int step;
		long num;
		
		public Number(int s, long n) {
			this.step = s;
			this.num = n;
		}
	}
	
	public int integerReplacement(int n) {
    	Queue<Number> que = new LinkedList<>();
    	que.add(new Number(0, n));
    	while (!que.isEmpty()) {
    		Number num = que.poll();
    		if (num.num == 1) {
    			return num.step;
    		} else if (num.num % 2 == 0) {
    			que.add(new Number(num.step+1, num.num/2));
    		} else {
    			que.add(new Number(num.step+1, num.num+1));
    			que.add(new Number(num.step+1, num.num-1));
    		}
    	}
    	return 0;
    }
	
	
//    public int integerReplacement(int n) {
//    	int min = Integer.MAX_VALUE;
//    	
//    	Queue<Number> que = new LinkedList<>();
//    	que.add(new Number(0, n));
//    	while (!que.isEmpty()) {
//    		Number num = que.poll();
//    		if (num.num == 1) {
//    			min = Math.min(min, num.step);
//    		} else if (num.num % 2 == 0 && num.step < min) {
//    			que.add(new Number(num.step+1, num.num/2));
//    		} else if (num.step < min) {
//    			que.add(new Number(num.step+1, num.num+1));
//    			que.add(new Number(num.step+1, num.num-1));
//    		}
//    	}
//    	return min;
//    }
}
