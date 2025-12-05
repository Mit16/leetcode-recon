package recursion;

//1. The provided definition for singly-linked list.
class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//2. Your Solution Class
class Solution {
 public boolean isPalindrome(ListNode head) {
     // ---------------------------------------------------------
     // TODO: WRITE YOUR LOGIC HERE
     // ---------------------------------------------------------
     
     return false; // Placeholder return
 }
}

//3. Driver Code to run the two specific examples
public class IsPalindrome {
 public static void main(String[] args) {
     Solution solution = new Solution();

     // --- Test Example 1 ---
     // Input: head = [1,2,2,1]
     int[] input1 = {1, 2, 2, 1};
     ListNode head1 = createLinkedList(input1);
     boolean result1 = solution.isPalindrome(head1);
     
     System.out.println("Example 1 Input: [1, 2, 2, 1]");
     System.out.println("Your Output: " + result1);
     System.out.println("Expected: true");
     System.out.println("-----------------------------");

     // --- Test Example 2 ---
     // Input: head = [1,2]
     int[] input2 = {1, 2};
     ListNode head2 = createLinkedList(input2);
     boolean result2 = solution.isPalindrome(head2);
     
     System.out.println("Example 2 Input: [1, 2]");
     System.out.println("Your Output: " + result2);
     System.out.println("Expected: false");
 }

 // Helper method to convert Java Array -> ListNode
 public static ListNode createLinkedList(int[] values) {
     if (values == null || values.length == 0) {
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
}