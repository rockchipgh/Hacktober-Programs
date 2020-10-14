class Solution {
    
    LinkedHashMap<String,Boolean> hm = new LinkedHashMap<>();
    public boolean isScramble(String s1, String s2) {
      if(s1.length() != s2.length()) return false;
        if(s1.compareTo(s2) == 0) return true;
        for(Character c: s1.toCharArray()){
            hm.put(""+c,true);
        }
        return solve(s1,s2);
    }
    public boolean solve(String a,String b){
         String key = a + " "+b;
        if(hm.containsKey(key)) return hm.get(key);
        if(a.equals(b) == true){
            hm.put(key,true);
            return true;
        }
    
    
        for(int i=1;i<a.length();i++){
            if(solve(a.substring(0,i),b.substring(0,i)) == true && solve(a.substring(i),b.substring(i)) == true){
                hm.put(key,true);
                return true;
            }
            if(solve(a.substring(0,i),b.substring(b.length()-i)) == true &&  solve(a.substring(i),b.substring(0,b.length()-i)) == true){
                hm.put(key,true);
                return true;
            }
        }
        hm.put(key,false);
        return false;
    }
}