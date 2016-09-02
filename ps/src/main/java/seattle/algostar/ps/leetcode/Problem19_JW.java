package seattle.algostar.ps.leetcode;

public class Problem19_JW {
	public static void main(String[] args) {
		new Problem19_JW().solve();
	}

	private void solve() {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		a.next = b;
		
		ListNode head = removeNthFromEnd(a, 1);
		
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode rhead = head;
		ListNode curr = head;
		
		int totalCnt = 0;
		while (curr != null) {
			totalCnt++;
			curr = curr.next;
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		
		int ix = totalCnt - n;
		if (ix == 0) {
			return rhead.next;
		} else {
			ListNode prev = null;
			curr = rhead;
			for (int step = 1; step <= ix; step++) {
				prev = curr;
				curr = curr.next;
			}
			prev.next = curr.next;
		}
		
		return rhead;
	}

	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
