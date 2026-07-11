package linkedList;

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {

        public ListNode reverseBetween(ListNode head, int left, int right) {

            // Your solution goes here
        	if(left == right || head == null) return head;
        	
        	ListNode current = head;
        	ListNode prev = null;
        	
        	for(int i= 0;current!=null && i< left-1;i++) {
        		prev = current;
        		current = current.next;
        	}
        	
        	ListNode last = prev;
        	ListNode newEnd = current;
        	
        	ListNode next = current.next;
        	for(int i = 0;i< right-left +1 && current != null;i++) {
        		current.next = prev;
        		prev=current;
        		current = next;
        		if(next!=null) next = next.next;
        	}
        	
        	if(last!=null) {
        		last.next = prev;
        	}else {
        		head = prev;
        	}
        	
        	newEnd.next = current;
        	
            return head;
        }
    }

    // ---------------- Helper Methods ----------------

    public static ListNode createList(int... values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    // ---------------- Main ----------------

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        ListNode head = createList(1, 2, 3, 4, 5);

        int left = 2;
        int right = 4;

        System.out.println("Original:");
        printList(head);

        head = solution.reverseBetween(head, left, right);

        System.out.println("After Reversing:");
        printList(head);
    }
}