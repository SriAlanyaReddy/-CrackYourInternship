class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int ind=0;
        List<Integer>temp=new ArrayList<>();
        findSubsets(ans,ind,temp,nums);
        return ans;
    }
    public void findSubsets(List<List<Integer>>ans,int ind,List<Integer>temp,int[] nums){
        if(ind>=nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[ind]);
        findSubsets(ans,ind+1,temp,nums);
        temp.remove(temp.size()-1);
        findSubsets(ans,ind+1,temp,nums);
    }
}