class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if (n == 0) {
            return \\;
        }

        String short_str = strs[0];
        
        for (String str : strs) {
            if (str.length() < short_str.length()) {
                short_str = str;
            }
        }

        for (int i = 0; i < short_str.length(); i++) {
            for (String str : strs) {
                if (str.charAt(i) != short_str.charAt(i)) {
                    return short_str.substring(0, i);
                }
            }
        }

        return short_str;

    }
}