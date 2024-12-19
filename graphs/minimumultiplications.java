class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
         if (start == end) {return 0;
         }
        int n=arr.length;
        int modulus=100000;
        int inf=Integer.MAX_VALUE;
        int dist[]=new int[100000];
        for(int i=0;i<100000;i++){
            dist[i]=inf;
        }
         dist[start] = 0;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int first=q.peek()[0];
            int steps=q.peek()[1];
            q.remove();
            for(int i=0;i<n;i++){
                int num=(arr[i]*first)%modulus;
                if(steps+1<dist[num]){
                    dist[num]=steps+1;
                    if(num==end)return dist[num];
                    q.add(new int[]{num,steps+1});
                }
            }
        }
        return -1;
    }
}
