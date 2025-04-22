package slidingWindowTwoPointer;

public class MaxPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum=0,rightSum=0, i=0;
        for(i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }
        int maxPoints=leftSum;
        int l=i-1,r=cardPoints.length-1;
        for(i=0;i<k;i++){
            leftSum-=cardPoints[l];
            l--;
            rightSum+=cardPoints[r-i];
            maxPoints=Math.max(maxPoints, leftSum+rightSum);
        }

        return maxPoints;
    }
}
