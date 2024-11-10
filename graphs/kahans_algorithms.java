class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int V=adj.size();//kahans alogorithms
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
        return topo;
        
    }
   
}
