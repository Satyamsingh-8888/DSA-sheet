class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                dp[i][j]=-1;
            }
        }

        return helper(m, n, dp);
    }

    private int helper(int m, int n, int dp[][]){
        if(m==1|| n==1) return 1;
        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n]=helper(m-1, n, dp)+helper(m, n-1, dp);

        return dp[m][n];
    }
}