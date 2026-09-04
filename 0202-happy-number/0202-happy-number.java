class Solution {
    public boolean isHappy(int n) {
      Set<Integer> st = new HashSet<>();
       st.add(n);
       
       while(n!=1){
        n = addMult(n);
        if(st.contains(n)){
            return false;
        }
        st.add(n);
       }
            
       return true;
        
    }

    private int addMult(int n){
        int result = 0;

        while(n>0){
            int temp = n % 10;
            result += temp * temp;
            n = n/10;
        }

        return result;
    }
}