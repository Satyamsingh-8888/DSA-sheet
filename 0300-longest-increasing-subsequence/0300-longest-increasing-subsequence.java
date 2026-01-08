class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums, 0, -1);
    }

    public int solve(int nums[], int index, int prev){
        if(index==nums.length) return 0;

        int skip=solve(nums, index+1, prev);
        int take=0;
        if(prev==-1 ||nums[index]>nums[prev]){
            take=1+solve(nums, index+1, index);
        }
        return Math.max(skip, take);
    }
}