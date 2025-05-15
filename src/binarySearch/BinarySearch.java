package com.pranav.striver_dsa_sheet.binarysearch1D;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8,9};
        int tar=5;
        int ans=bs(a,tar);
        System.out.println(ans);
    }
    static int bs(int[] a, int tar){
        int l=0, h=a.length-1;
        int ans=-1;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]==tar) return m;
            if(tar>a[m])l=m+1;
            else h=h-1;
        }
        return ans; //dummy return
    }


}
