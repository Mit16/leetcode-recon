package recursion;

import java.util.*;

public class FindingEvenNumbers {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // --- Test Case 1 ---
        int[] digits1 = {2, 1, 3, 0};
        runTest(solution, digits1, 1);

        // --- Test Case 2 ---
        int[] digits2 = {2, 2, 8, 8, 2};
        runTest(solution, digits2, 2);

        // --- Test Case 3 ---
        int[] digits3 = {3, 7, 5};
        runTest(solution, digits3, 3);
    }

    // Helper method to print inputs and outputs cleanly
    private static void runTest(Solution solution, int[] digits, int testCaseNum) {
        System.out.println("--- Test Case " + testCaseNum + " ---");
        System.out.println("Input: " + Arrays.toString(digits));
        
        long startTime = System.nanoTime();
        int[] result = solution.findEvenNumbers(digits);
        long endTime = System.nanoTime();
        
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution Time: " + (endTime - startTime) / 1000 + " µs");
        System.out.println();
    }

    /**
     * Write your code inside this class.
     */
    static class Solution {
    	// Brute Force approch
//        public int[] findEvenNumbers(int[] digits) {
//            HashSet<Integer> uniqueMap= new HashSet<>();
//            
//            for (int i=0;i<digits.length;i++) {
//            	for(int j=0;j<digits.length;j++) {
//            		for(int k=0;k<digits.length;k++) {
//            			if(i==j||j==k||i==k) {
//            				continue;
//            			}
//            			int num = digits[i]*100+digits[j]*10+digits[k];
//            			if(num>=100 && num%2==0) {
//            				uniqueMap.add(num);
//            			}
//            		}
//            	}
//            }
//            
//        
//            int[] result = new int[uniqueMap.size()];
//            int index = 0;
//            for (int val : uniqueMap) {
//                result[index++] = val;
//            }
//            
//            
//            Arrays.sort(result);
//            
//            return result;          
//        }
    	
    	// HashMap approch
//    	public int[] findEvenNumbers(int[] digits) {
//           HashMap<Integer, Integer> uniqueMap = new HashMap<>();
//           for (int i : digits) {
//			uniqueMap.put(i, uniqueMap.getOrDefault(i, 0) + 1);
//           }
//           
//           List<Integer> resultList = new ArrayList<>();
//           
//           for(int i=100;i<=998;i+=2) {
//        	   int x = i / 100;       // 1st digit
//               int y = (i / 10) % 10; // 2nd digit
//               int z = i % 10;        // 3rd digit
//               
//               HashMap<Integer, Integer> required = new HashMap<>();
//               
//               required.put(x, required.getOrDefault(x, 0) + 1);
//               required.put(y, required.getOrDefault(y, 0) + 1);
//               required.put(z, required.getOrDefault(z, 0) + 1);
//
//               boolean possible = true;
//               
//               // Iterate over the digits we NEED (x, y, z)
//               for (int key : required.keySet()) {
//                   int countNeeded = required.get(key);
//                   int countHave = uniqueMap.getOrDefault(key, 0);
//                   
//                   if (countHave < countNeeded) {
//                       possible = false;
//                       break;
//                   }
//               }
//
//               if (possible) {
//                   resultList.add(i);
//               }
//        	   
//           }
//           
//           int[] result = new int[resultList.size()];
//           for (int k = 0; k < resultList.size(); k++) {
//               result[k] = resultList.get(k);
//           }
//           return result;
//        }
    	
    	
    	// HashMap approch but with array
    	public int[] findEvenNumbers(int[] digits) {
           int[] freq = new int[10];
           for (int digit : digits) {
			freq[digit]++;
           }
           
           List<Integer> results = new ArrayList<>();
           for(int i=100;i<=998;i+=2) {
        	   int x=i/100;
        	   int y=(i/10)%10;
        	   int z=i%10;
        	   
        	   freq[x]--;
        	   freq[y]--;
        	   freq[z]--;
        	   
        	   if(freq[x]>=0 && freq[y]>=0 && freq[z]>=0) {
        		   results.add(i);
        	   }
        	   
        	   freq[x]++;
        	   freq[y]++;
        	   freq[z]++;
        	   
           }
           
           int[] result = new int[results.size()];
           for (int k = 0; k < results.size(); k++) {
               result[k] = results.get(k);
           }

           return result;
        }
    	
    }
}	