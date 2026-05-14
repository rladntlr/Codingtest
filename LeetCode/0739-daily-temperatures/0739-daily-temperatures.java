class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){

            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                
                int prev = s.pop();
                ans[prev] = i -prev;
            }
            s.push(i);
        }
        return ans;
    }
}