import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if(s == null || s.length() == 0 || words.length == 0){
            return indices;
        }
        Arrays.sort(words);
        // System.out.println(Arrays.toString(words));

        
        int len = words[0].length();
        int left = 0;
        int right = len * (words.length) - 1;
        // System.out.println(s.length());
        while(left <= right && right < s.length()){
            String temp[] = new String[words.length];
            System.out.println(left+"  "+right);
            int count = 0;
            int t = left;
            while(t<= right && count < words.length){
                // System.out.println(t);
                temp[count] = s.substring(t, t + len);
                t = t + len;
                count++;
            }
            // System.out.println(Arrays.toString(temp));
            System.out.println(Arrays.toString(temp));

            Arrays.sort(temp);
            if(Arrays.equals(temp,words)){
                indices.add(left);
            }
            
            left = left+1;
            right = right+1;
            
        }
        return indices;
        
        
        
        
        
        
        
    }
}