package slidingWindowTwoPointer;

public class MaxConsecutiveOnes_K_FlipsOfZeros {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,maxLen=0;
        // int[] hash=new int[2];
        //no need to use hashmap as there is only condition to check zeros

        int zeros=0;

        while(r<nums.length){
            if(nums[r]==0) zeros++;
            while(zeros>k){
                if(nums[l] == 0){
                    zeros--;
                }
                l++;
            }
            maxLen=Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}

