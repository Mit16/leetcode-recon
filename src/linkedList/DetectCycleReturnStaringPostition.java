package linkedList;

public class DetectCycleReturnStaringPostition {

	static class ListNode {
		private int val;
		private ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {

		public int lengthCycle(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;

			while (fast != null & fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					int length = 0;
					ListNode temp = slow;
					do {
						temp = temp.next;
						length++;
					} while (temp != slow);
					return length;
				}
			}
			return 0;
		}

		public ListNode detectCycle(ListNode head) {
			int length = 0;
			ListNode fast = head;
			ListNode slow = head;

			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					length = lengthCycle(slow);
					break;
				}
			}

			if (length == 0)
				return null;

			// find the start node
			ListNode first = head;
			ListNode second = head;
			while (length > 0) {
				second = second.next;
				length--;
			}

			// keep moving forward and they will meet at cycle start
			while (first != second) {
				first = first.next;
				second = second.next;
			}

			return second;
		}

		private ListNode detectCyycle2(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					break;
				}
			}

			if (fast == null || fast.next == null) {
				return null;
			}

			ListNode first = head;
			ListNode second = slow;
			while (first != second) {
				first = first.next;
				second = second.next;
			}

			return first;
		}

		private ListNode detectCyycle3(ListNode head) {
			ListNode fast = head;
			ListNode slow = head;
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					ListNode first = head;
					while (first != slow) {
						first = first.next;
						slow = slow.next;
					}

					return first;
				}
			}

			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
