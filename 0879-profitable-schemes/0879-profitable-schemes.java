class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD=1000000007;
        int [][] dp=new int[n+1][minProfit+1];
        dp[0][0]=1;
        for(int i=0; i<group.length; i++){
            int mem=group[i];
            int pro=profit[i];
            for(int j=n; j>=mem; j--){// backward to avoid same crime multi times
                for(int k=minProfit; k>=0; k--){
                    int newProfit=Math.min(minProfit, k+pro);
                    dp[j][newProfit] = 
    (dp[j][newProfit] + dp[j - mem][k]) % MOD;
                }
            }
        }

        int res=0;
        for(int j=0; j<=n; j++){
            res = (res + dp[j][minProfit]) % MOD;
        }
        return res;
    }
}