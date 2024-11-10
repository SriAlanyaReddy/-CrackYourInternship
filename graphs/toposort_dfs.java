class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        int V=adj.size();
        Stack<Integer>st=new Stack<>();
        int visited[]=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,st,adj);
            }
        }
        ArrayList<Integer> topo=new ArrayList<>();
        
        while(!st.isEmpty()){
            topo.add(st.peek());
            st.pop();
        }
        return topo;
    }
    private static void dfs(int node,int[] visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        for(int adjnode:adj.get(node)){
            if(visited[adjnode]==0){
                dfs(adjnode,visited,st,adj);
            }
        }
        st.push(node);
    }
}
