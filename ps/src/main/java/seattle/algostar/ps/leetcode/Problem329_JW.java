package seattle.algostar.ps.leetcode;

public class Problem329_JW {
	public static void main(String[] args) {
		new Problem329_JW().solve();
	}

	private void solve() {
		int[][] m = {{7,7,5},
					{2,4,6},
					{8,2,0}};
		System.out.println(longestIncreasingPath(m));
	}
	
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
    	boolean[][] visit = new boolean[matrix.length][matrix[0].length];
    	memo = new int[matrix.length][matrix[0].length];
    	
    	int max = 0;
    	for (int y = 0; y < matrix.length; y++) {
    		for (int x = 0; x < matrix[y].length; x++) {
    			visit[y][x] = true;
    			max = Math.max(max, go(y, x, matrix, visit));
    			visit[y][x] = false;
    		}
    	}
    	
        return max;
    }

    int[][] memo;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};
	
	private int go(int y, int x, int[][] matrix, boolean[][] visit) {
	    if (memo[y][x] != 0) return memo[y][x];
		int pathCnt = 1;
		
		for (int d = 0; d < 4; d++) {
			int ny = dy[d] + y;
			int nx = dx[d] + x;
			if (0 <= ny && ny < matrix.length && 0 <= nx && nx < matrix[0].length && !visit[ny][nx]) {
				if (matrix[y][x] < matrix[ny][nx]) {
					visit[ny][nx] = true;
					pathCnt = Math.max(pathCnt, go(ny, nx, matrix, visit) + 1);
					visit[ny][nx] = false;
				}
			}
		}
		return memo[y][x] = pathCnt;
	}
}
