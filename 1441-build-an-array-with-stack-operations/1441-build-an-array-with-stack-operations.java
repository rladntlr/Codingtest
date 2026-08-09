class Solution {
    public List<String> buildArray(int[] target, int n) {
        int idx = 0;
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if (idx == target.length) {
                break;
            }

            if (i == target[idx]) {
                ans.add("Push");
                idx++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
            
        }
        return ans;
    }
}