class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int [][] adj=new int[n+1][n+1];

        for(int []edge: edges){
            int u=edge[0];
            int v=edge[1];
            adj[u][v]=1;
            adj[v][u]=1;
        }
        for(int i=1; i<=n; i++){
            int count=0;
            for(int j=1; j<=n; j++){
                if(adj[i][j]==1){
                    count++;
                }
            }
            if(count==n-1){
                return i;
            }
        }
        return -1;
    }
}