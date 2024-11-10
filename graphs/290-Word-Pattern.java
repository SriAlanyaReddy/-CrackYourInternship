class Solution {
    public boolean wordPattern(String pat, String s) {
             String[] words = s.split(\ \);
            if(words.length!=pat.length()){
                return false;
            }
            HashMap<Character,String>ptos=new HashMap<>();
              HashMap<String,Character>stop=new HashMap<>();
              for(int i=0;i<pat.length();i++){
                String w1=words[i];
                Character ch=pat.charAt(i);
                if(ptos.containsKey(ch)){
                    if(!ptos.get(ch).equals(w1)){
                        return false;
                    }
                }
                else{
                    ptos.put(ch,w1);
                }
                if(stop.containsKey(w1)){
                    if(!stop.get(w1).equals(ch)){
                        return false;
                    }
                }
                else{
                    stop.put(w1,ch);
                }
              }
              return true;
    }
}