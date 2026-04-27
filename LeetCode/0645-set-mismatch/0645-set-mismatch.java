class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] visited = new int[nums.length+1];
        for(int num: nums){
            visited[num]++;
        }
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == 0) ans[1] = i;
            if(visited[i] > 1) ans[0] = i;
        }
        return ans;
    }
}