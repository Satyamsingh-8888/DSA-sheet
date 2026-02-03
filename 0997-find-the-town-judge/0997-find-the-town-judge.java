class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] in=new int[n+1];
        int [] out=new int[n+1];
        for(int [] edge: trust){
            int a=edge[0];
            int b=edge[1];
            out[a]++;
            in[b]++;
        }
        for(int i=1; i<=n; i++){
            if(out[i]==0 && in[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}