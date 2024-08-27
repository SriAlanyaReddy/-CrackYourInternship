class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>s1=new HashSet<>();
        List<List<Integer>> l=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int s=nums[i]+nums[j]+nums[k];
                if(s==0){
                    s1.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(s<0){
                     j++;
                }
                else{
                    k--;
                }

            }
        }
        l.addAll(s1);
        return l;
    }
}