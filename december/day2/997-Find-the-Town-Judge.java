class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[]=new int[n+1];
        int outdegree[]=new int[n+1];

        for(int i=0;i<trust.length;i++){
            int v1=trust[i][0];
            int v2=trust[i][1];
            outdegree[v1]++;
            indegree[v2]++;

        }
        for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0)return i;
        }
        return -1;
    }
}