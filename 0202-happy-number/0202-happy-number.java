class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = next(slow);
            fast = next(next(fast));

            

        } while (slow != fast);

        if (slow==1) return true;

        return false;

    }

    private int next(int n) {
        int result = 0;

        while (n > 0) {
            int temp = n % 10;
            result += temp * temp;
            n = n / 10;
        }

        return result;
    }
}