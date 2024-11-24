class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1 && target==nums[0]){
            return 0;
        }
        else if(nums.length==1 ){
            return -1;
        }
        return searchtarget(0,nums,target);
    }
    public int searchtarget(int index,int[] a, int target){
        if(a[index]==target) return index;
        if(index==a.length-1){
            return -1;
        }
        return searchtarget(index+1,a,target);
    }
}