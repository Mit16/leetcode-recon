class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> allCombinations = generateAll(n, "");

        List<String> validSequences = new ArrayList<>();
        for (String seq : allCombinations) {
            if (isValid(seq)) {
                validSequences.add(seq);
            }
        }

        return validSequences;

    }

    private List<String> generateAll(int n, String sequence) {
        List<String> l1 = new ArrayList<>();
        if (sequence.length() >= 2 * n) {
            l1.add(sequence);
            return l1;
        }

        List<String> left = generateAll(n, sequence + "(");
        List<String> right = generateAll(n, sequence + ")");

        l1.addAll(left);
        l1.addAll(right);

        return l1;
    }

    private boolean isValid(String seq) {
        int balance = 0;
        for (char c : seq.toCharArray()) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}