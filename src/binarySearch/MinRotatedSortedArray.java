package com.pranav.striver_dsa_sheet.binarysearch1D;

public class MinRotatedSortedArray {

    public static void main(String[] args) {
//        int[] a={6,7,8,1,2,3,4,5};
//        System.out.println(findMin(a));

        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(findMin(arr)); // Expected output: 0




//        int[] arr1 = {3, 4, 5, 1, 2};
//        System.out.println(findMin(arr1)); // ✅ Output: 1
//
//        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
//        System.out.println(findMin(arr2)); // ✅ Output: 0
//
//        int[] arr3 = {11, 13, 15, 17};
//        System.out.println(findMin(arr3)); // ✅ Output: 11 (Already sorted, no rotation)
//
//        int[] arr4 = {2, 2, 2, 0, 1};
//        System.out.println(findMin(arr4)); // ✅ Output: 0 (Handles duplicates)

    }
    static int findMin(int[] a){
        int l=0,h=a.length-1,min=Integer.MAX_VALUE;
        while(l<=h){
            int m=(l+h)/2;
            if(a[l]<=a[h]){ //optimisation,,,optional
                min=Math.min(min, a[l]);
                break;
            }


            if(a[m]>=a[l]){   //ls
                min=Math.min(min,a[l]);
                l=m+1;
            }else if(a[m]<=a[h]){
                min=Math.min(min, a[m]);
                h=m-1;
            }
        }
        return min;
    }



    //this is standard canonical method used widely, so look through it

//    static int findMin(int[] a) {
//        int l = 0, h = a.length - 1;
//        while (l < h) {
//            int m = (l + h) / 2;
//            if (a[m] > a[h]) {
//                l = m + 1;
//            } else {
//                h = m;
//            }
//        }
//        return a[l];
//    }

}
