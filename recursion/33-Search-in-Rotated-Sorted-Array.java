class Solution {
    public int search(int[] a, int target) {
        int low=0;
        int high=a.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            //check left array is sorted
            if(a[mid]==target)return mid;
           else if(a[low]<=a[mid]){
            if(target>=a[low] && a[mid]>target){
                high=mid-1;
            }
           else{
                low=mid+1;
            }
           }
           else{
            if(a[mid]<target && a[high]>=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

           }
            
        }
        return -1;
    }
}