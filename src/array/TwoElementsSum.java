package com.pranav.striver_dsa_sheet.arraymedium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoElementsSum {
    public static void main(String[] args) {
        int[] a={2,6,5,8,11};
        int tar=14;

        TwoElementsSum obj=new TwoElementsSum();
//        obj.twoSum_bruteForce(a,tar);

//        obj.twoSum_map(a,tar);

        obj.twoSum_sorting(a,tar);

    }
    void twoSum_bruteForce(int[] a, int tar){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]+a[j]==tar){
                    System.out.println(i+","+j);
                    return;
                }
            }
        }
    }

    void twoSum_map(int[] a, int tar){
        HashMap<Integer, Integer> sumMap=new HashMap<>();
        for(int i=0;i<a.length;i++){
            int rem=tar-a[i];
            if(sumMap.containsKey(rem)){
                System.out.println(i+","+ sumMap.get(rem));
            }
            sumMap.put(a[i], i);
        }

    }

    void twoSum_sorting(int[] a, int tar){
        Arrays.sort(a);
        int l=0,r=a.length-1;
        while(l<r){
            if(a[l]+a[r]==tar){
                System.out.println(l+","+r);
                return;
            }
            else if(a[l]+a[r]>tar){
                r--;
            }
            else l++;
        }
    }
}
