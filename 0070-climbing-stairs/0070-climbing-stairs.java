class Solution {
    public int climbStairs(int n) {
        int ways[]=new int[n+1];
        return soln(n, ways);
    }

    public int soln(int n, int ways[]){
        if(n==0){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        if(ways[n]!=0){
            return ways[n];
        }
        ways[n]=soln(n-1, ways)+soln(n-2, ways);
        return ways[n];
    }
}