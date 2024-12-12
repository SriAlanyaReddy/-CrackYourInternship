class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int source =0;
        int destination =graph.length-1;
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
   
        sourcetoTarget(source,graph,ans,temp,destination);
        return ans;
    }
    public void sourcetoTarget(int source,int[][] graph,List<List<Integer>>ans,List<Integer>temp,int destination){
         temp.add(source);
        if(source==destination){
            ans.add(new ArrayList<>(temp));
            
        }
        
        for(int adjnode:graph[source]){
            
                    
                     sourcetoTarget(adjnode,graph,ans,temp,destination);
                     
           
        }
        temp.remove(temp.size()-1);
    }
}