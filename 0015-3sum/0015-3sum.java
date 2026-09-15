class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int i = 0;

        while (i < n - 2) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int curr = nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (curr + nums[left] + nums[right] > 0) {
                    right--;
                } else if (curr + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            i++;
        }

        return result;
    }
}