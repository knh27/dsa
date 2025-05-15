package com.pranav.striver_dsa_sheet.arrayeasy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayPosSum {
    public static void main(String[] args) {
        int[]a={9,1,2,3,5,1,1,9};
        int sum=10, result=3;
        LongestSubArrayPosSum obj=new LongestSubArrayPosSum();
//        obj.longestSubArray1(a);

//        obj.longestSubArray2(a,sum);

//        obj.longestSubArray_map(a, sum);

        obj.longestSubArray_optimised(a,10);
    }


    void longestSubArray1(int[] a){
        int max=0;
        for(int i=0;i<a.length;i++){
            for(int j=i;j<a.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=a[k];
                }
                if(sum==10){
                    if(max<(j-i+1)) max=j-i+1;
                }
            }
        }
        System.out.println(max);
    }

    void longestSubArray2(int[] a, int k){
        int max=0;int j;
        for(int i=0;i<a.length;i++){
            int sum=0;
            for(j=i;j<a.length;j++){
                sum=sum+a[j];
                if(sum==k){
                    max=Math.max(max,j-i+1);
//                    break; if numbers are positive
                }
            }


        }
        System.out.println(max);
    }

    void longestSubArray_map(int[] a, int k){
        HashMap<Integer, Integer> preSum=new HashMap<>();
        int sum=0, maxLen=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum==k){
                maxLen=Math.max(maxLen, i+1);
            }
            int rem=sum-k;

            if(preSum.containsKey(rem)){
                int len=i-preSum.get(rem);
                maxLen=Math.max(maxLen, len);
            }

            if(!preSum.containsKey(sum)){
                preSum.put(sum, i);
            }

        }
        System.out.println(maxLen);
    }

    void longestSubArray_optimised(int[] a, int k){
        int r=0,l=0,sum=0,maxLen=0;
        while(r<a.length){
            sum+=a[r];
            if(sum==k){
                maxLen=Math.max(maxLen, r-l+1);
            }
            while(l<=r && sum>k){
                sum-=a[l];
                l++;
            }

            r++;
        }
        System.out.println(maxLen);
    }



}

