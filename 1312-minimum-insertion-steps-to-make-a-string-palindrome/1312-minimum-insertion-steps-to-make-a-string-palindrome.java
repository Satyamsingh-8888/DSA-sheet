class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        return solve(s, 0, n-1, dp);
    }

    private int solve(String s, int first, int last, int dp[][]){
        if(first>=last) return 0;

        if(dp[first][last]!=0) return dp[first][last];

        if(s.charAt(first)==s.charAt(last)) {
            dp[first][last]=solve(s, first+1, last-1, dp);

        }else{
            dp[first][last]=1+Math.min(solve(s, first+1, last, dp), solve(s, first, last-1, dp));
        }
        return dp[first][last];
    }
}