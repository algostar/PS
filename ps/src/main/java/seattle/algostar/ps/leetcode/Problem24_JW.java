package seattle.algostar.ps.leetcode;

public class Problem24_JW {
	public static void main(String[] args) {
		new Problem24_JW().solve();
	}

	private void solve() {
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		ListNode h = swapPairs(h1);
		System.err.println(h);
	}
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pprev = new ListNode(-1);
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode rhead = curr;
        
        int step = 1;
        while (curr != null) {
        	if (step % 2 == 1) {
        		pprev.next = curr;
        		prev.next = curr.next;
        		curr.next = prev;
        		prev = curr;
        		curr = prev.next;
        	}

        	pprev = prev;
        	prev = curr;
        	curr = curr.next;
        	step++;
        }
        return rhead;
    }
    
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}
}
