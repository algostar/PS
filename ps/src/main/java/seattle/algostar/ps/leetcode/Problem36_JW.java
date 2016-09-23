package seattle.algostar.ps.leetcode;

public class Problem36_JW {
	public static void main(String[] args) {
		new Problem36_JW().solve();
	}

	private void solve() {
		char[][] board = { 
			{'1','2','.'},
			{'.','1','.'},
			{'2','3','.'}
		
		};
		System.out.println(isValidSudoku(board));;
	}
	
    public boolean isValidSudoku(char[][] board) {
    	if (board.length == 0) return false;
    	
    	for (int y = 0; y < board.length; y++) {
    		int map = 0;
    		for (int x = 0; x < board[y].length; x++) {
    			if (board[y][x] != '.') {
    				int num = board[y][x] - '0';
    				if ((map & (1 << num)) == 0) {
    					map = map | (1 << num);
    				} else{
    					return false;
    				}
    			}
    		}
    	}
    	
    	for (int x = 0; x < board[0].length; x++) {
    		int map = 0;
    		for (int y = 0; y < board.length; y++) {
    			if (board[y][x] != '.') {
    				int num = board[y][x] - '0';
    				if ((map & (1 << num)) == 0) {
    					map = map | (1 << num);
    				} else{
    					return false;
    				}
    			}
    		}
    	}
    	
    	int[] ss = {0, 3, 6};
    	for (int i = 0; i < ss.length; i++) {
    		for (int y = 0; y < 3; y++) {
    			for (int x = 0; x < 3; x++) {
    				int sx = ss[i] + x;
    				int sy = ss[i] + y;
    				if (board[sy][sx] != '.') {
    				}
    			}
    		}
    	}
    	
    	
        
        return true;
    }
}

