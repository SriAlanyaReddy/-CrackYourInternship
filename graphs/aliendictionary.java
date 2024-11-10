class Solution {
    static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj) {
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
        return topo;
    }
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String r1=dict[i];
            String r2=dict[i+1];
            int min=Math.min(r1.length(),r2.length());
            for(int j=0;j<min;j++){
                if(r1.charAt(j)!=r2.charAt(j)){
                    adj.get(r1.charAt(j)-'a').add(r2.charAt(j)-'a');
                    break;
                }
            }
        }
        int[] topo=topologicalSort(adj);
        StringBuilder res=new StringBuilder();
        for(int t:topo){
            res.append((char)(t+'a'));
        }
        return res.toString();
    }
}
