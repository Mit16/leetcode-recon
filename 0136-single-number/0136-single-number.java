class Solution {
    public int singleNumber(int[] nums) {
        int result = Arrays.stream(nums).reduce(0,(a,b)-> a^b);
        return result;
    }
}