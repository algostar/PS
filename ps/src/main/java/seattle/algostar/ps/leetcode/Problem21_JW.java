package seattle.algostar.ps.leetcode;

public class Problem21_JW {
	public static void main(String[] args) {
		new Problem21_JW().solve();
	}

	private void solve() {
		
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(1);
		ListNode curr = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if (l1 != null) {
			curr.next = l1;
		} else if (l2 != null) {
			curr.next = l2;
		}
		
		return head.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}

