class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int expsum=n*(n+1)/2;
        int asum=0;
        for(int i=0; i<n; i++){
            asum+=nums[i];
        
        }
        return expsum-asum;
    }
}