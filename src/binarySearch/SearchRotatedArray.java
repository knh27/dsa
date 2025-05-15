package com.pranav.striver_dsa_sheet.binarysearch1D;

public class SearchRotatedArray {

    public static void main(String[] args) {
//        int[] a={11,11,11,11,11,11};
//        System.out.println(bsRotatedArray(a,11));
//        System.out.println(bsRotatedArrayDuplicates(a,11));


        int[] arr1 = {2, 2, 2, 3, 3, 4, 2};
        System.out.println(bsRotatedArrayDuplicates(arr1, 3)); // ✅ Output: 3

        int[] arr2 = {4, 5, 6, 6, 7, 0, 1, 2, 4, 4};
        System.out.println(bsRotatedArrayDuplicates(arr2, 0)); // ✅ Output: 5

        int[] arr3 = {2, 2, 2, 2, 2, 2, 2};
        System.out.println(bsRotatedArrayDuplicates(arr3, 2)); // ✅ Output: Any valid index (e.g., 0)

        int[] arr4 = {3, 3, 3, 3, 3, 3};
        System.out.println(bsRotatedArrayDuplicates(arr4, 5)); // ✅ Output: -1 (Not found)

    }


    static int bsRotatedArray(int[] a, int tar){
        int l=0,h=a.length-1,ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]==tar)return m;
            if(a[h]>=a[m]){//right sorted
                if(tar>=a[m] && tar<=a[h]){
                    l=m+1;
                }else{
                    h=m-1;
                }
            }else if(a[m]>a[l]){    //left sorted
                if(tar>=a[l] && tar<=a[m]){
                    h=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return ans;
    }

    static int bsRotatedArrayDuplicates(int[] a, int tar){
        int l=0,h=a.length-1,ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]==tar)return m;
            if(a[l]==a[m] && a[m]==a[h]){
                l=l+1;
                h=h-1;
                continue;
            }
            if(a[h]>=a[m]){//right sorted
                if(tar>=a[m] && tar<=a[h]){
                    l=m+1;
                }else{
                    h=m-1;
                }
            }else if(a[m]>a[l]){    //left sorted
                if(tar>=a[l] && tar<=a[m]){
                    h=m-1;
                }else{
                    l=m+1;
                }
            }
        }
        return ans;
    }



}
