class Solution {
    public List<String> letterCombinations(String digits) {
        String[] comb = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");

        for (char c : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            String tString = comb[c - '2'];

            for (String i : result) {
                for (char t : tString.toCharArray()) {
                    temp.add(i + t);
                }
            }

            result = temp;
        }

        return result;
    }
}