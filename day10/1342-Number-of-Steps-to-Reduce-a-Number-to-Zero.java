class Solution {
    public int numberOfSteps(int n) {
        if(n==0){
            return 0;
        }
        return (n%2==0)?1+numberOfSteps(n/2):1+numberOfSteps(n-1);
    }
}