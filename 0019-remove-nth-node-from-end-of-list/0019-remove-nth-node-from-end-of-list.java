/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int i;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        i = n + 1;
        recur(dummy);
        return dummy.next;
    }

    private void recur(ListNode root) {
        if (root == null)
            return;

        recur(root.next);
        i--;
        if (i == 0 && root.next != null) {
            root.next = root.next.next;
        }

    }
}