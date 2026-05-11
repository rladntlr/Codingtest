class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for(int num : nums){
            cnt[num]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            if(cnt[i]==0)
            ans.add(i);
        }
        return ans;
    }
}