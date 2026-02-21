class Solution {
    public int countPrimeSetBits(int left, int right) {

        HashSet<Integer> prime=new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19));
        int result=0;
        for(int i=left; i<=right; i++){
            int setB=Integer.bitCount(i);
            if(prime.contains(setB)){
                result++;
            }
        }
        return result;
    }
}