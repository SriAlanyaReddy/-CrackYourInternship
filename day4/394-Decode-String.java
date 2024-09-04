class Solution {
    public String decodeString(String s) {
      Stack <StringBuilder> stringstack=new Stack<>();
      Stack <Integer> numStack=new Stack<>();
      StringBuilder sb=new StringBuilder();
      int sum=0;
      for(int i=0;i<s.length();i++){
       if(Character.isDigit(s.charAt(i))){
        sum=sum*10+s.charAt(i)-'0';
       }
       else if(s.charAt(i)=='['){
        numStack.push(sum);
        sum=0;
        stringstack.push(sb);
        sb=new StringBuilder();

       }
       else if(s.charAt(i)==']'){

        StringBuilder temp=sb;
           int val=numStack.pop();
        sb=stringstack.pop();
        while(val!=0){
            sb.append(temp);
            val--;
        }
        

       }
       else{
        sb.append(s.charAt(i));
       }
      }
      return sb.toString();
    }
}