class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        int prov=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                dfs(i, isConnected, vis, n);
                prov++;
            }
        }
        return prov;
    }

    private void dfs(int city, int [][] isConnected, boolean[] vis, int n){
        vis[city]=true;
        for(int j=0; j<n; j++){
            if(isConnected[city][j]==1 && (!vis[j])){
                dfs(j, isConnected, vis, n);
            }
        }
    }
}