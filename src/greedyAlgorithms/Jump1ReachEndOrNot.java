package greedyAlgorithms;

public class Jump1ReachEndOrNot {
    public boolean canJump(int[] nums) {
        int i=0, maxInd=0;
        while(i<nums.length){
            int pos=i+nums[i];
            maxInd=Math.max(maxInd, pos);
            if(maxInd>=nums.length-1){
                return true;
            }
            else if(i>=maxInd){
                return false;
            }
            i++;
        }
        return false;
    }
}
