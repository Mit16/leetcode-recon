package linkedList;

import java.util.*;

class MinPairRemovalSolution {
	
	static class Node{
		private long val;
		private int id;
		private Node prev,next;
		boolean removed=false;
		
		Node(long val,int id){
			this.val = val;
			this.id = id;
		}
	}
	
	static class Pair{
		long sum;
		Node node;
		
		public Pair(long sum,Node node) {
			// TODO Auto-generated constructor stub
			this.sum = sum;
			this.node = node;
		}	
	}
	
	
    public int minOperations(int[] nums) {
        // Write your solution here.
        // Tip: Simulating the array list removals directly is O(N^2).
        // Try using a Doubly Linked List to manage neighbors and a 
        // PriorityQueue to track the minimum sums efficiently.
    	
    	int n = nums.length;
    	if(n<2) return 0;
    	
    	Node[] nodeMap = new Node[n];
    	Node head = new Node(nums[0],0);
    	nodeMap[0] = head;
    	Node curr = head;
    	
    	for(int i = 1;i<n;i++) {
    		Node newNode = new Node(nums[i],i);
    		curr.next = newNode;
    		newNode.prev =curr;
    		curr = newNode;
    		nodeMap[i] = newNode;
    	}
    	
    	PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
    		if(a.sum != b.sum) return Long.compare(a.sum, b.sum);
    		return Integer.compare(a.node.id, b.node.id);
    	});
    	
    	int badCount = 0;
    	curr = head;
    	while(curr!=null && curr.next!=null) {
    		if(curr.val>curr.next.val) badCount++;
    		pq.offer(new Pair(curr.val+curr.next.val,curr));
    		curr = curr.next;
    	}
    	
    	if (badCount==0) return 0;
    	
    	int ops=0;
    	
    	while(badCount>0) {
    		if(pq.isEmpty()) break;
    		
    		Pair top = pq.poll();
    		Node u = top.node;
    		Node v = u.next;
    		
    		if(u.removed || v==null||v.removed) continue;
    		if(u.val + v.val != top.sum) continue;
    		
    		if(u.prev != null && u.prev.val > u.val) badCount--;
    		
    		if(u.val >v.val) badCount--;
    		
    		if(v.next != null && v.val > v.next.val) badCount--;
    		
    		u.val+=v.val;
    		u.next = v.next;
    		if(v.next != null) {
    			v.next.prev = u;
    		}
    		v.removed = true;
    		
    		if(u.prev != null) {
    			pq.offer(new Pair(u.prev.val + u.val, u.prev));
    		}
    		
    		if(u.next!=null) {
    			pq.offer(new Pair(u.val+u.next.val,u));
    		}
    		
    		ops++;
    	}
        
        return 0;
    }
}

public class MinimumPairRemovalII {

    public static void main(String[] args) {
        MinPairRemovalSolution solver = new MinPairRemovalSolution();

        // --- Example 1 ---
        // Input: [5, 2, 3, 1]
        // Output: 2
        // Logic: (3,1) -> 4 => [5, 2, 4]. (2,4) -> 6 => [5, 6]. Sorted.
        int[] nums1 = {5, 2, 3, 1};
        System.out.println("--- Test Case 1 ---");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Result: " + solver.minOperations(nums1));

        // --- Example 2 ---
        // Input: [1, 2, 2]
        // Output: 0 (Already sorted)
        int[] nums2 = {1, 2, 2};
        System.out.println("\n--- Test Case 2 ---");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Result: " + solver.minOperations(nums2));
        
        // --- Extra Test Case (Negative numbers) ---
        // Input: [10, -5, -5, 20]
        // Min pair (-5, -5) -> -10 => [10, -10, 20]
        // Min pair (10, -10) -> 0   => [0, 20] (Sorted)
        // Ops: 2
        int[] nums3 = {10, -5, -5, 20};
        System.out.println("\n--- Test Case 3 ---");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Result: " + solver.minOperations(nums3));
    }
}