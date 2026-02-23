class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        int usub=1<<k;
        HashSet<String> st=new HashSet<>();
        for(int i=k; i<=s.length();i++){
            String sub=s.substring(i-k, i);
            if(!st.contains(sub)){
                st.add(sub);
                usub--;
            }
            if(usub==0) return true;
        }
        return false;
    }
}