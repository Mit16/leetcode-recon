class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = (n * m) - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / m][mid % m] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return matrix[left / m][left % m] == target ? true : false;
    }
}