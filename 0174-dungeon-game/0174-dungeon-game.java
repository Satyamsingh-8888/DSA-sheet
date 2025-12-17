class Solution {
    int[][] dp;
    int m, n;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, dungeon);
    }

    private int solve(int i, int j, int[][] dungeon) {
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (i + 1 < m)
            down = solve(i + 1, j, dungeon);

        if (j + 1 < n)
            right = solve(i, j + 1, dungeon);

        int need = Math.min(down, right);
        dp[i][j] = Math.max(1, need - dungeon[i][j]);

        return dp[i][j];
    }
}
