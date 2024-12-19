class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        // Map to store digit-to-letter mappings
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', \abc\);
        phoneMap.put('3', \def\);
        phoneMap.put('4', \ghi\);
        phoneMap.put('5', \jkl\);
        phoneMap.put('6', \mno\);
        phoneMap.put('7', \pqrs\);
        phoneMap.put('8', \tuv\);
        phoneMap.put('9', \wxyz\);
        List<String>ans=new ArrayList<>();
        findCombinations(digits,phoneMap,ans,0,new StringBuilder());
        return ans;

    }
     public void findCombinations(String digits,Map<Character, String>phoneMap,  List<String>ans,int ind,StringBuilder current){
        if(ind==digits.length()){
            ans.add(current.toString());
            return;
        }
        char digit=digits.charAt(ind);
        String  letters=phoneMap.get(digit);
        for(char letter:letters.toCharArray()){
            current.append(letter);
            findCombinations(digits,phoneMap,ans,ind+1,current);
            current.deleteCharAt(current.length()-1);

        }
     }
}