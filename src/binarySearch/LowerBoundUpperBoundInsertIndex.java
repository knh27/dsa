package com.pranav.striver_dsa_sheet.binarysearch1D;

public class LowerBoundUpperBoundInsertIndex {
    public static void main(String[] args) {
        int[] a={1,3,5,7,9,11,14,16,19};
        int tar=17;
        int ans=ub(a,19);
        System.out.println(ans);
    }

    static int lb(int[] a, int tar){ //index such that element at that index greater than or equal to tar
        int l=0, h=a.length-1;
        int ans=a.length;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]>=tar){
                ans=m;
                h=m-1;
            }else l=m+1;
        }
        return ans;

    }

    static int ub(int[] a, int tar){ //index such that element at that index greater than target
        int l=0, h=a.length-1,ans=a.length;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]>tar){
                ans=m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}
