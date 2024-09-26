class Solution {
    public static boolean isCommon(String[] s, int len) {
        String prefix = s[0].substring(0, len);  
        int n = s.length;
        for (int i = 1; i < n; i++) {
            if (!s[i].startsWith(prefix)) { 
                return false;
            }
        }
        return true;
    }
    public String longestCommonPrefix(String[] s) {
        if (s.length == 0) return \\; 

        int low = 0;
        int minLen = Integer.MAX_VALUE;
        for (String str : s) {
            minLen = Math.min(minLen, str.length());  
        }
        int high = minLen;
        String ss=\\;
        StringBuilder sb = new StringBuilder(ss);

        while (low <= high) {
            int mid = (low + high) / 2;  
            if (isCommon(s, mid)) {
                sb.setLength(0); 
                sb.append(s[0], 0, mid);
                low = mid + 1; 
            } else {
                high = mid - 1;  
            }
        }
        return sb.toString();
    }
}