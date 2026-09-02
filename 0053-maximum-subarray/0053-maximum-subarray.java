class Solution {

    private int[] memo;

    public int maxSubArray(int[] nums) {

        memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            answer = Math.max(answer, recurse(nums, i));
        }

        return answer;
    }

    private int recurse(int[] nums, int idx) {

        if (idx == 0) {
            return nums[0];
        }

        if (memo[idx] != Integer.MIN_VALUE) {
            return memo[idx];
        }

        int current = Math.max(
            nums[idx],
            nums[idx] + recurse(nums, idx - 1)
        );

        return memo[idx] = current;
    }
}