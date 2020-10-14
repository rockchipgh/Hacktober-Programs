class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int containsOne = 0;
        for(int i=0;i<n;i++){
            
            if(nums[i] <= 0 || nums[i] > n) nums[i] = 0;
            if(nums[i] == 1) containsOne = 1;
        }
        if(containsOne == 0) return 1;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 0) continue;
            else{
                int index = Math.abs(nums[i]) - 1;
                if(nums[index] == 0) nums[index] = 0;
            }
        }
    }
}