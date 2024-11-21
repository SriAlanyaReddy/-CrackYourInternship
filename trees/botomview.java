class Pair{
    Node root;
    int hd;
    Pair(Node root,int hd){
        this.hd=hd;
        this.root=root;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here TreeMap<Integer,Integer>mp=new TreeMap<>();
       
        //using vertical order traversal
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        //add value & verticallevel
        while(!q.isEmpty()){
            Pair current=q.poll();
            Node currentnode=current.root;
            int hd=current.hd;
           mp.put(hd,currentnode.data);
           if(currentnode.left!=null){
               q.add(new Pair(currentnode.left,hd-1));
           }
           if(currentnode.right!=null){
               q.add(new Pair(currentnode.right,hd+1));
           }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(int key:mp.keySet()){
            ans.add(mp.get(key));
        }
        return ans;
    }
   
}
