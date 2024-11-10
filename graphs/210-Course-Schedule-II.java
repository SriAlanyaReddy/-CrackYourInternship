class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());

        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
        }
        int V=numCourses;
           int[] inorder=new int[V];//bfs//kahans algorithm toposort
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
        int[] topo=new int[V];
        int i=0;
        while(!q.isEmpty()){
            int current=q.peek();
            q.remove();
            topo[i++]=current;
            for(int adjnode:adj.get(current)){
                inorder[adjnode]--;
                if(inorder[adjnode]==0){
                    q.add(adjnode);
                }
            }
        }
        if(i==V) return topo;
        return new int[0];
    }
}