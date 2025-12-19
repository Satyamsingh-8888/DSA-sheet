class Solution {
    public int countPartitions(int[] nums) {
        int sum=0;
        for(int x: nums){
            sum+=x;
        }
        return (sum % 2 == 0) ? nums.length - 1 : 0;
    }
}