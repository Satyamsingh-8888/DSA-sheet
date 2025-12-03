class Solution {
    public int fib(int n) {
        int f[]=new int[n+1];
        return fib(n, f);
    }

    public int fib(int n, int f[]){
        if(n==0|| n==1){
            return n;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n]=fib(n-1, f)+fib(n-2, f);
        return f[n];
    }
}