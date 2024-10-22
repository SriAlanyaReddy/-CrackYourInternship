class Solution {
public:
    int maxProduct(vector<int>& a) {
         double prefix=1;
         double suffix=1;
         double maxn=INT_MIN;
        int n=a.size();
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix=prefix*a[i];
            suffix=suffix*a[n-i-1];
            maxn=max(maxn,max(prefix,suffix));
        }
        return static_cast<int>(maxn);
    }
};