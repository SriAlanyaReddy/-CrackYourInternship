    }
}
*/
class Pair{
    Node root;
    int hd;
    Pair(Node root,int hd){
        this.hd=hd;
        this.root=root;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        //my approach is using map
        //using vertical order traversal
        TreeMap<Integer,Integer>mp=new TreeMap<>();
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
        //add value & verticallevel
        while(!q.isEmpty()){
            Pair current=q.poll();
            Node currentnode=current.root;
            int hd=current.hd;
            if(mp.get(hd)==null) mp.put(hd,currentnode.data);
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
