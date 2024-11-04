class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V=adj.size();
        ArrayList<Integer>bfslist=new ArrayList<>();
        boolean visited[]=new boolean[V];
        
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int current=q.poll();
            bfslist.add(current);
            for(Integer it:adj.get(current)){
                if(visited[it]==false){
                    visited[it]=true;
                    q.add(it);
                }
            }
        }
        return bfslist;
    }
}
