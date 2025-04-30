package greedyAlgorithms;

public class Jump2MinJumpsToReachEnd {
    public int jump(int[] a){
        int l=0, r=0, n=a.length, j=0;
        while(r<n-1){
            int maxInd=0;
            for(int i=l;i<=r;i++){
             maxInd=Math.max(maxInd, i+a[i]);
            }
            l=r+1;
            r=maxInd;
            j++;
        }
        return j;
    }
}
