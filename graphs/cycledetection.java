class Solution {
    // Function to detect cycle in a directed graph.
  
   
    public boolean isCyclic(int V,ArrayList<ArrayList<Integer>>adj) {
        // code here
       //kahans alogorithms
        int[] inorder=new int[V];//bfs
        for(int i=0;i<V;i++){
            for(int adjnode:adj.get(i)){
                inorder[adjnode]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> topo=new ArrayList<Integer>();
        while(!q.isEmpty()){
            int current=q.peek();
            q.remove();
            topo.add(current);
            for(int adjnode:adj.get(current)){
                inorder[adjnode]--;
                if(inorder[adjnode]==0){
                    q.add(adjnode);
                }
            }
        }
        if(topo.size()==V) return false;
        return true;
    }
}
