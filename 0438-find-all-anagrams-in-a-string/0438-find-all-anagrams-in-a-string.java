class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int l1 = s.length();
        int l2 = p.length();

        if (l1 < l2) {
            return new ArrayList<>();
        }

        int[] pFreq = freq(p);
        int[] windowFreq = freq(s.substring(0, l2));

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= l1 - l2; i++) {

            if (i > 0) {
                // Remove character leaving the window
                windowFreq[s.charAt(i - 1) - 'a']--;

                // Add character entering the window
                windowFreq[s.charAt(i + l2 - 1) - 'a']++;
            }

            if (compare(windowFreq, pFreq)) {
                result.add(i);
            }
        }

        return result;
    }

    private int[] freq(String s) {

        int[] result = new int[26];

        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }

        return result;
    }

    private boolean compare(int[] s1, int[] s2) {

        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }
}