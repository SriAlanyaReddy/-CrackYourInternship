class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int s1=0;
        int s2=0;
        for(int i=0;i<n;i++){
            s1=s1+nums1[i];
            s2=s2+nums2[i];
        }
        if(n!=0){
            return (s2-s1)/n;
        }
        return n;
    }
}