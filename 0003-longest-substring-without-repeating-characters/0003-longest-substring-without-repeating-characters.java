class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int max = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Set<Character> unique = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (unique.contains(s.charAt(j))) {
                    break;
                }

                unique.add(s.charAt(j));
            }

            max = Math.max(max, unique.size());
        }

        return max;

    }
}