class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int ans[] = new int[nums.length];
        int cnt = 0;
        for(int j = 0; j < nums.length; j++){
            for(int i = 0 ; i < nums.length; i++){
                if(nums[j] > nums[i]){
                    cnt++;
                }
            }
            ans[j] = cnt;
            cnt = 0;
        }
        return ans;
    }
}