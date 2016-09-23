package seattle.algostar.ps.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem167_JW {
	public static void main(String[] args) {
		new Problem167_JW().solve();
	}

	private void solve() {
		int[] numbers = {0,0,3,4};
		int target = 0;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}
	
	
    public int[] twoSum1(int[] numbers, int target) {
    	int[] res = new int[2];
    	for (int i = 0; i < numbers.length; i++) {
    		int rest = target - numbers[i];
    		int j = Arrays.binarySearch(numbers, rest);
    		if (0 <= j && i != j) {
    			res[0] = Math.min(i, j) + 1;
    			res[1] = Math.max(i, j) + 1;
    		}
    	}
    	return res;
    }
    
    public int[] twoSum(int[] numbers, int target) {
    	int[] res = new int[2];
    	int i = 0;
    	int j = numbers.length-1;
    	while (i < j) {
    		int sum = numbers[i] + numbers[j];
    		if (target < sum) {
    			j--;
    		} else if (sum < target) {
    			i++;
    		} else {
    			res[0] = i + 1;
    			res[1] = j + 1;
    			break;
    		}
    	}
    	return res;
    }
    
    
    public int[] twoSum2(int[] numbers, int target) {
    	int[] res = new int[2];
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < numbers.length; i++) {
    		map.put(numbers[i], i);
    	}
    	
    	for (int i = 0; i < numbers.length; i++) {
    		int rest = target - numbers[i];
    		Integer j = map.get(rest);
    		if (j != null && i != j) {
    			res[0] = Math.min(i, j) + 1;
    			res[1] = Math.max(i, j) + 1;
    		}
    	}
    	return res;
    }
}
