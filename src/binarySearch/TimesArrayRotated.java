package com.pranav.striver_dsa_sheet.binarysearch1D;

public class TimesArrayRotated {
    public static void main(String[] args) {
        /*
            find index of minimum element in rotated array

        */

        int[] arr1 = {3, 4, 5, 1, 2};
        System.out.println(findMinIndex(arr1)); // ✅ Output: 1

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMinIndex(arr2)); // ✅ Output: 0

        int[] arr3 = {11, 13, 15, 17};
        System.out.println(findMinIndex(arr3)); // ✅ Output: 11 (Already sorted, no rotation)

        int[] arr4 = {2, 2, 2, 0, 1};
        System.out.println(findMinIndex(arr4)); // ✅ Output: 0 (Handles duplicates)

    }

    static int findMinIndex(int[] a){
        int l=0, h=a.length-1, min=0;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]>=a[l]){ //left sorted
                if(a[l]<a[min]){
                    min=l;
                }
                l=m+1;
            }else if(a[m]<=a[h]){//right sorted
                if(a[m]<a[min]){
                    min=m;
                }
                h=m-1;
            }
        }
        return min;
    }
}
