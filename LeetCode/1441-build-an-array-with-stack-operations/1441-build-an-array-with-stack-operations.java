class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int idx = 0;

        for(int i = 1; i <= n; i++){
            ans.add("Push");

            if(target[idx] == i){
                idx++;

                if(idx==target.length){
                    break;
                }
            }
            else{
                ans.add("Pop");
            }
        }
        return ans;
    }
}