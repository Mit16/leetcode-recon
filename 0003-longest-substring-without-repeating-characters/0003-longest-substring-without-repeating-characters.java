class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        Set<Character> unique = new HashSet<>();
        int left = 0;
        int max = Integer.MIN_VALUE;

        for (int right = 0; right < n; right++) {

            while (unique.contains(s.charAt(right))) {
                unique.remove(s.charAt(left));
                left++;
            }

            unique.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}