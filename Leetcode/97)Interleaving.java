class Solution {
    HashMap<String,Boolean> hm = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        return helper(s1,s2,s3,0,0,0);
    }
    public boolean helper(String s1,String s2,String s3,int i,int j,int k){
        if(i > s1.length()) return false;
        if(j > s2.length()) return false;
        if(k == s3.length()) return true;
        String key = ""+i+" "+j+" "+k;
        if(hm.containsKey(key)) return hm.get(key);
        if(i == s1.length()){
            if(s2.charAt(j) == s3.charAt(k)) hm.put(key,helper(s1,s2,s3,i,j+1,k+1));
            else hm.put(key,false);
        }
        else if(j == s2.length()){
            if(s1.charAt(i) == s3.charAt(k)) hm.put(key,helper(s1,s2,s3,i+1,j,k+1));
            else hm.put(key,false);
        }
        else if(s1.charAt(i) == s2.charAt(j)){
            if(s3.charAt(k) == s1.charAt(i)){
                hm.put(key,helper(s1,s2,s3,i+1,j,k+1) || helper(s1,s2,s3,i,j+1,k+1));
            }
            else hm.put(key,false);
        }
        else if(s1.charAt(i) == s3.charAt(k)){
            hm.put(key,helper(s1,s2,s3,i+1,j,k+1));
        }
        else if(s2.charAt(j) == s3.charAt(k)){
            hm.put(key,helper(s1,s2,s3,i,j+1,k+1));
            
        }
        else hm.put(key,false);
        return hm.get(key);
    }
}