class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(result, new StringBuilder(), 0, 0, n);
        return result;

    }

    private void generateAll(List<String> result, StringBuilder sequence, int open, int close, int max) {

        if (sequence.length() == 2 * max) {
            result.add(sequence.toString());
            return;
        }

        if (open < max) {
            sequence.append('(');
            generateAll(result, sequence, open + 1, close, max);
            sequence.deleteCharAt(sequence.length() - 1);
        }

        if (close < open) {
            sequence.append(')');
            generateAll(result, sequence, open, close + 1, max);
            sequence.deleteCharAt(sequence.length() - 1);
        }

    }

}