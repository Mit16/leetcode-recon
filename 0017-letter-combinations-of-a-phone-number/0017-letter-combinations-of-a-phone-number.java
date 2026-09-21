class Solution {
    private static String[] comb = new String[] { "","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        recur(digits,0,new StringBuilder(),result);
        return result;
    }

    private void recur(String digits, int i,StringBuilder s,List<String> result){
        if(i == digits.length()){
            result.add(s.toString());
            return;
        }

        for(char c: comb[digits.charAt(i)-'0'].toCharArray()){
            s.append(c);
            recur(digits,i+1,s,result);
            s.deleteCharAt(s.length()-1);
        }
    }
}