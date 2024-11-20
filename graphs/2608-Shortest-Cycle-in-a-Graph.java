class Solution {
    int min=Integer.MAX_VALUE;
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //this loop for unconnected graph
        for(int start=0;start<n;start++){
           min=Math.min(min,bfs(adj,start));
        }
        return min!=Integer.MAX_VALUE?min:-1;
    }
    public int bfs( ArrayList<ArrayList<Integer>>adj,int start){
        int n=adj.size();
        int[] dist=new int[n];
        Arrays.fill(dist,-1);
        dist[start]=0;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{start,-1});
        int minimumcycle=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int currentcell[]=q.poll();
            int current=currentcell[0];
            int parent=currentcell[1];
            for(int adjnode:adj.get(current)){
                if(dist[adjnode]<0){
                    //non visited;
                    dist[adjnode]=dist[current]+1;
                    q.add(new int[]{adjnode,current});
                }
                else if(adjnode!=parent){
                    //we calculate minimum path if there are muliple cycle for same satrt point taking only minimum path of cylce for that start point
                  minimumcycle=Math.min(dist[adjnode]+dist[current]+1,minimumcycle);
                }
            }
                    }
            return minimumcycle;

    }
}