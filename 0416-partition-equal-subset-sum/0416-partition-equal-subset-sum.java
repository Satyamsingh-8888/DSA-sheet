class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num: nums) sum+=num;
        if(sum%2!=0) return false;
        int W=sum/2;
        boolean[][] dp=new boolean[n+1][W+1];
        for(int i=0; i<n+1; i++){
            dp[i][0]=true;
        }

        for(int i=1; i<n+1; i++){
            for(int w=1; w<W+1; w++){
                if(nums[i-1]<=w){
                    dp[i][w]=dp[i-1][w-nums[i-1]]|| dp[i-1][w];
                }else{
                    dp[i][w]=dp[i-1][w];
                }
            }
        }
        return dp[n][W];
    }
}