class Solution {
    public List<String> validStrings(int n) {
        List<String> result=new ArrayList<>();
        answer("", n, result);
        return result;
    }

    public void answer(String curr, int n, List<String> result){
        if(curr.length()==n){
            result.add(curr);
            return;
        }

        answer(curr+"1", n, result);
        if(curr.length()==0 || curr.charAt(curr.length()-1)!='0'){
            answer(curr+"0", n, result);
        }
    }
}