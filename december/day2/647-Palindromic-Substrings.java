class Solution {
    public int countSubstrings(String s) {
        int c = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            // Odd length palindrome (centered at index i)
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                c++;
                l--;
                r++;
            }

            // Even length palindrome (centered between indices i and i+1)
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                c++;
                l--;
                r++;
            }
        }
        
        return c;
    }
}
