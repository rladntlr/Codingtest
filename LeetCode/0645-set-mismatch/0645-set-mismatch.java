class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int actualSum = n*(n+1)/2;

        int arraySum = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            arraySum += num;
            set.add(num);
        }

        int uniqueSum = 0;
        for(int num : set){
            uniqueSum += num;
        }
        
        int duplicate = arraySum - uniqueSum;
        int missing = actualSum - uniqueSum;

        return new int[]{duplicate, missing};
    }
}