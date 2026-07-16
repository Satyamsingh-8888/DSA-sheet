class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int case1=solve(nums, 0, n-2);
        int case2=solve(nums, 1, n-1);
        return Math.max(case1, case2);
    }

    private int solve(int nums[], int st, int end){
        int len=end-st+1;
        int dp[]=new int[len];
        dp[0]=nums[st];
        for(int i=1; i<len; i++){
            int take=nums[st+i];
            if(i>1) take+=dp[i-2];
            int nottake=dp[i-1];
            dp[i]=Math.max(take, nottake);
        }
        return dp[len-1];
    }
}