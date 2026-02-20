class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list=new ArrayList<>();
        int start=0;
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                count++;
            }else{
                count--;
            }

            if(count==0){
                String inner=s.substring(start+1, i);
                String process=makeLargestSpecial(inner);
                list.add("1"+ process+"0");
                start=i+1;
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String str: list){
            sb.append(str);
        }

        return sb.toString();
    }
}