class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do {
            slow = next(slow);
            fast = next(next(fast));

            if (fast == 1 || slow == 1)
                return true;

        } while (slow != fast);

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