package linkedList;

public class ReverseNodesInKGroup {

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

        public ListNode reverseKGroup(ListNode head, int k) {

            // Your solution goes here
        	if(k<=1 ||  head == null)
        		return head;

        	ListNode prev = null;
        	ListNode current = head;
        	
        	while(current != null) {
        		int count = 0;
        		
        		ListNode temp = current;
        		while(temp != null && count < k) {
        			temp = temp.next;
        			count++;
        		}
        		
        		if(count<k) break;	
        		
        		ListNode last = prev;
        		ListNode newEnd = current;
        		
        		for (int i = 0; i < k; i++) {
        		    ListNode next = current.next;
        		    current.next = prev;
        		    prev = current;
        		    current = next;
        		}
        		
        		if(last!=null) {
        			last.next = prev;
        		}else {
        			head = prev;
        		}
        		
        		newEnd.next = current;
        		prev = newEnd;
        		
        		
        	}
        	
            return head;
        }

    }

    // ---------------- Helper Methods ----------------

    public static ListNode createList(int... values) {
        if (values.length == 0)
            return null;

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

        ListNode head = createList(1, 2, 3, 4, 5);

        System.out.println("Original:");
        printList(head);

        int k = 2;

        head = solution.reverseKGroup(head, k);

        System.out.println("After Reversing:");
        printList(head);

    }

}