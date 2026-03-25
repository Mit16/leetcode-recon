package binarySearch;
import java.util.*;

class SeparateSquaresSolution {
    public double separateSquares(int[][] squares) {
        // Write your solution here
        // Tip: The total area is constant. You need a 'y' where 
        // Area_Below(y) == Total_Area / 2.
        double low = Integer.MIN_VALUE;
        double high = Integer.MAX_VALUE;
        double total = 0.00000;
        
        for(int[] square:squares) {
        	double x = square[0];
        	double y = square[1];
        	double l = square[2];
        	
        	total += l*l;
        	
        	low= Math.min(low,y);
        	high = Math.max(high,y+l);
        }
        
        double result_y= 0.00000;
        
        while(high-low > 1e-5) {
        	double mid_y = low + (high-low)/2;
        	
        	result_y = mid_y;
        	
        	if(check(squares,mid_y,total)==true) {
        		high = mid_y;
        	}else {
        		low= mid_y;
        	}
        }
        
        return result_y;
    }
    
    private boolean check(int[][] squares,double mid_y,double total) {
    	double bottom_area = 0.00000;
    	
    	for(int[] square:squares) {
    		double y = square[1];
    		double l = square[2];
    		
    		double bot_y = y;
    		double top_y = y+l;
    		
    		if(mid_y >=top_y) {
    			bottom_area += l*l;
    		}else if(mid_y > bot_y) {
    			bottom_area += (mid_y-bot_y)*l;
    		}
    	}
    	
    	return bottom_area >= total/2.0;
    }
}

public class SeparateSquaresI {

    public static void main(String[] args) {
        SeparateSquaresSolution solver = new SeparateSquaresSolution();

        // --- Example 1 ---
        // Input: squares = [[0,0,1],[2,2,1]]
        // Expected Output: 1.00000
        int[][] squares1 = {
            {0, 0, 1},
            {2, 2, 1}
        };
        System.out.println("--- Test Case 1 ---");
        double result1 = solver.separateSquares(squares1);
        System.out.printf("Output: %.5f\n", result1);

        // --- Example 2 ---
        // Input: squares = [[0,0,2],[1,1,1]]
        // Expected Output: 1.16667
        int[][] squares2 = {
            {0, 0, 2},
            {1, 1, 1}
        };
        System.out.println("\n--- Test Case 2 ---");
        double result2 = solver.separateSquares(squares2);
        System.out.printf("Output: %.5f\n", result2);
    }
}