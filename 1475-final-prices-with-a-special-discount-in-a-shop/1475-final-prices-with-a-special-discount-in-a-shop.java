class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = prices.clone();
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i < prices.length; i++){

            while(!s.isEmpty() && prices[s.peek()] >= prices[i]){

                ans[s.pop()] -= prices[i];
            }
            s.push(i);
        }
        return ans;
    }
}