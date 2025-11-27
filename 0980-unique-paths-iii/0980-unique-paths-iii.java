class Solution {
    int rows, cols, totalSteps, result;
    
    public int uniquePathsIII(int[][] grid) {
         rows=grid.length;
         cols=grid[0].length;
         result=0;
         totalSteps=0;
        int startx=0;
        int starty=0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]!=-1) totalSteps++;
                if(grid[i][j]==1){
                    startx=i;
                    starty=j;
                }
            }
        }
        dfs(grid, startx, starty, 1);
        return result;
    }

    private void dfs(int[][] grid, int x, int y, int steps){
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) return;

        if (grid[x][y] == 2) {
            if (steps == totalSteps) result++;
            return;
        }

        
        int temp = grid[x][y];
        grid[x][y] = -1;

        dfs(grid, x + 1, y, steps + 1);
        dfs(grid, x - 1, y, steps + 1);
        dfs(grid, x, y + 1, steps + 1);
        dfs(grid, x, y - 1, steps + 1);

        grid[x][y] = temp;
    }
}