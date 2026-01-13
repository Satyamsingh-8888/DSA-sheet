class Solution {
    public int longestStrChain(String[] words) {
        private boolean ispredecessor(String s1, String s2){
            if(s2.length()!=s1.length()+1) return false;

            int i=0;
            int j=0;
            boolean skipped=false;
            while(i<s1.length()&& j<s2.length()){
                if(s1.charAt(i)==s2.charAt(j)){
                    i++;
                    j++;
                }else{
                    if(skipped) return false;
                    skipped=true;
                    j++;
                }


            }

            return true;
        }

        public int longeststringchain(String[] words){
            Arrays.sort(words, (a, b) -> a.length() - b.length());

            int n=words.length;

        }
    }
}