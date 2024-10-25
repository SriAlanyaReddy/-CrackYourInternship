class Solution {
    public boolean validPalindrome(String s) {
        
        char[] s1=s.toCharArray();
        int n=s1.length;
        int i=0;
        int j=n-1;
        while(i<j){
            if(s1[i]!=s1[j]){
               return testpalindome(s1,i+1,j) || testpalindome(s1,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean testpalindome(char[] s,int start,int end){
        while(start<=end){
            if(s[start]!=s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}