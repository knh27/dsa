package slidingWindowTwoPointer;

public class NoOfBinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return subarraySumLessThan(nums, goal)-subarraySumLessThan(nums, goal-1);
    }

    public int subarraySumLessThan(int[] nums, int goal){
        if(goal<0) return 0;
        int l=0, r=0, c=0, sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            c+=r-l+1;
            r++;
        }
        return c;
    }
}
