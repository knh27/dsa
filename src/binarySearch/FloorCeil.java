package com.pranav.striver_dsa_sheet.binarysearch1D;

public class FloorCeil {

    public static void main(String[] args) {
        int[] a={2,3,4,5,6,7,9,11};
        int ans=floor(a, 1);
        int ans2=ceil(a, 10);

        System.out.println(ans2);

    }

    static int floor(int[] a, int tar){
        int l=lb(a, tar);
        if(tar<a[0]) return -1;
        else if(l<a.length && tar==a[l])return a[l];
        else return a[l-1];
//        return (l==a.length || a[l]!=tar) ? a[l-1]:a[l];
    }

    static int ceil(int[] a, int tar){
        int l=lb(a, tar);
        if(tar>a[a.length-1]) return -1;
        return a[l];
    }

    static int lb(int[] a, int tar){
        int l=0, h=a.length-1, ans=a.length;
        while(l<=h){
            int m=(l+h)/2;
            if(a[m]>=tar){
                ans=m;
                h=m-1;
            }else l=m+1;
        }
        return ans;
    }
}
