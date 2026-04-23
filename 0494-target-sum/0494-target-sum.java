class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int num: nums)sum+=num;
        if((sum+target)%2!=0|| sum<Math.abs(target)) return 0;
        int W=(sum+target)/2;
        int dp[][]=new int[n+1][W+1];
        dp[0][0]=1;
        for(int i=1; i<n+1; i++){
            for(int w=0; w<W+1; w++){
                if(nums[i-1]<=w){
                    dp[i][w]=dp[i-1][w-nums[i-1]]+dp[i-1][w];
                }else{
                    dp[i][w]=dp[i-1][w];
                }
            }
        }
        return dp[n][W];
        
    }
}