class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return Math.min(minCost(cost, 0, memo), minCost(cost, 1, memo));
    }

    private int minCost(int[] cost, int i, int[] memo) {
        if (i >= cost.length)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        return memo[i] = cost[i] + Math.min(minCost(cost, i + 1, memo), minCost(cost, i + 2, memo));
    }

}