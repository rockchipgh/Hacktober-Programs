class Solution {
    public String minWindow(String s, String t) {
        String res = "";
        if(s.length() == 0 || t.length() == 0) return res;
        HashMap<Character,Integer> hmT = new HashMap<>();
        
        // count freq of each character in t:
        for(int i=0;i<t.length();i++){
            hmT.put(t.charAt(i),hmT.getOrDefault(t.charAt(i),0)+1);
        }
        
        // the total no of unique characters in t:
        int required = hmT.size();
        
        // the total no of formed in the current window:
        int formed = 0;
        
        // HashMap to store freq of current elements in the window:
        HashMap<Character,Integer> windowT = new HashMap<>();
        
        // left and right ptrs:
        int left = 0;
        int right = 0;
         
        int result[] = {Integer.MAX_VALUE,0,0};
        
        while(right<s.length()){
            windowT.put(s.charAt(right),windowT.getOrDefault(s.charAt(right),0)+1);
            if(hmT.containsKey(s.charAt(right)) && windowT.get(s.charAt(right)).intValue() == hmT.get(s.charAt(right)).intValue()){
                formed++;
            }
            while((left <= right) && formed==required){
                // updating the values :
                if(right-left+1 < result[0]){
                    result[0] = right-left+1;
                    result[1] = left;
                    result[2] = right;
                }
                windowT.put(s.charAt(left), windowT.get(s.charAt(left))-1);
                if(hmT.containsKey(s.charAt(left)) && windowT.get(s.charAt(left)).intValue()< hmT.get(s.charAt(left)).intValue()){
                    formed--;
                }
                left++;
            }
             right++;
        }
        if(result[0] == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(result[1],result[2]+1);
       
        
        
        
    }
}