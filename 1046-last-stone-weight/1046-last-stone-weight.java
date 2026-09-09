class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];

        List<Integer> newS = new ArrayList<>();
        
        for (int i : stones) {
            newS.add(i);
        }

        while (newS.size() > 1) {
            Collections.sort(newS);

            int y = newS.remove(newS.size() - 1);
            int x = newS.remove(newS.size() - 1);

            if (x != y) {
                newS.add(y - x);
            }
        }

        return newS.isEmpty() ? 0 : newS.get(0);

    }
}