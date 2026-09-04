class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = bitsCounter(i);
        }

        return result;

    }

    private int bitsCounter(int n) {
        int result = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                result++;
            n = n >> 1;
        }

        return result;
    }
}