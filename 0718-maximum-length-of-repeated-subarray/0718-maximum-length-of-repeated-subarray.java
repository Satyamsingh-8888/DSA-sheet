class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int dp[][]=new int[m+1][n+1];
        int maximumlength=0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    maximumlength=Math.max(maximumlength, dp[i][j]);
                }else{
                    Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return maximumlength;
    }
}