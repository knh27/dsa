package slidingWindowTwoPointer;

public class ConstantWindow {
    public static void main(String[] args) {
//        int[] a=new int[6];
//        a={1,3,2,6,4,7}; cannot assign value outside declaration

        int[]a={3,2,5,7,5,1,8};
        int[]b={4,7,5,6,3,11,13,15};
        ConstantWindow obj=new ConstantWindow();

        obj.maxSumOfSize_K_Subarray(a,3);
        obj.longestSubarraySumLessThan_K(b,23);


    }

    public void maxSumOfSize_K_Subarray(int[] a,int k){
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+a[i];
        }

        int maxSum=sum, l=0, r=k;
        while(r<a.length){
            sum=sum-a[l];
            l++;
            sum=sum+a[r];
            r++;
            maxSum=Math.max(sum, maxSum);
        }

        System.out.println(maxSum);
    }




    //we can  use if instead this inner while loop to get maxLen bcz there is no need to shrink it extra...means decrease l

    //in case of sub-array we have to shrink it to get actual result
    public void longestSubarraySumLessThan_K(int[] a, int k){
        int l=0,r=0, sum=0, maxLen=0;

        while(r<a.length){
            sum=sum+a[r];
            if(sum<k){
                maxLen=Math.max(maxLen, r-l+1);
            }

            if(sum>=k){
                sum=sum-a[l];
                l++;
            }


            r++;
        }

        System.out.println(maxLen);
    }
    public void longestSubarraySumLessThan_K2(int[] a, int k){
        int l=0,r=0, sum=0, maxLen=0;

        while(r<a.length){
            sum=sum+a[r];
            if(sum<k){
                maxLen=Math.max(maxLen, r-l+1);
            }

            while(sum>=k){
                sum=sum-a[l];
                l++;
            }


            r++;
        }

//        System.out.println(maxLen);d
    }
}
