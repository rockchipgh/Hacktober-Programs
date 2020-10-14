class Solution {
    public int longestValidParentheses(String s) {
       if(s == null || s.length() == 0){
           return 0;
       } 
        if(s.length() == 1){
            return 0;
        }
        int dp[] = new int[s.length()];
        int maxim = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == ')' && s.charAt(i-1) == '('){
                dp[i] = (i>=2)? dp[i-2]+2 : 2;
            }
            // else if(s.charAt(i) == '')
            else if(s.charAt(i) == ')' && s.charAt(i-1) == ')'){
                if( i - dp[i-1] >0 && s.charAt( i - dp[i-1] - 1) == '('){
                    dp[i] = dp[i-1] + ( (i - dp[i-1]>=2)? dp[i - dp[i-1] - 2] + 2 : 2);
                }
            }
            maxim = Math.max(maxim,dp[i]);
            
        }
        return maxim;
    }
}