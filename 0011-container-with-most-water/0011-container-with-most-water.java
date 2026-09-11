class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if (n == 0)
            return 0;
        int left = 0;
        int right = n - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int weight = right - left;

            int area = minHeight * weight;

            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}