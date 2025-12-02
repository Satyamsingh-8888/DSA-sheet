class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        traverse(nums, new ArrayList<>() ,0, result);
        return result;
    }
    public void traverse(int[] nums, List<Integer> current, int index, List<List<Integer>> result){

        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        traverse(nums, current, index+1, result);

        current.remove(current.size()-1);
        traverse(nums, current, index+1, result);
    }

}