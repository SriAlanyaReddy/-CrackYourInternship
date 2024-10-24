class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int cs=0;
        int totalvalue=0;
        for(int i=0;i<n;i++){
            if(cs+boxTypes[i][0]<=truckSize){
                cs+=boxTypes[i][0];
                totalvalue+=boxTypes[i][1]*boxTypes[i][0];
            }
            else{
                int remain=truckSize-cs;
                totalvalue+=boxTypes[i][1]*remain;
                break;

            }
          
        }
        return totalvalue;
    }
}