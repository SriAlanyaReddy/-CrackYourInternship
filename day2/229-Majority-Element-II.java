class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        Map<Integer,Integer>mp=new HashMap<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        List<Integer>l=new ArrayList<>();
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
                   if(e.getValue()>n){
                    l.add(e.getKey());
                   }
        }
        return l;
        
    }
}