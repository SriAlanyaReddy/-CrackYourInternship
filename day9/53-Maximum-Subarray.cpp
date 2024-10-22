class Solution {
public:
    int maxSubArray(vector<int>& a) {
        
        int maxn=INT_MIN;
        int n=a.size();
        int s=0;
        for(int i=0;i<n;i++){
            s=s+a[i];
            maxn=max(maxn,s);
            if(s<0){
                s=0;
            }
        }
        return maxn;
    }
};