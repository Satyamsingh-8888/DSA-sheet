class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int num: nums) totalsum+=num;

        if(totalsum%2!=0) return false;

        int target=totalsum/2;

        Boolean dp[][]=new Boolean[n+1][target+1];
        return solve(nums, n, target, dp);
    }

    private Boolean solve(int arr[], int n, int target, Boolean dp[][]){
        if(target==0) return true;
        if(n==0) return false;
        if(dp[n][target]!=null) return dp[n][target];

        if(arr[n-1]<=target){
            dp[n][target]=solve(arr, n-1, target-arr[n-1], dp)|| solve(arr, n-1, target, dp);
        }else{
            dp[n][target]=solve(arr, n-1, target, dp);
        }

        return dp[n][target];
    }
}