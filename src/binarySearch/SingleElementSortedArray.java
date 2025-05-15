package com.pranav.striver_dsa_sheet.binarysearch1D;

public class SingleElementSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println(singleElementSortedArray(a));
    }

    static int singleElementSortedArray(int[] a){
        int l=1, h=a.length-2;
        while(l<=h){
            int m=(l+h)/2;
            if(a[0]!=a[1]) return a[0];
            if(a[a.length-1]!=a[a.length-2]) return a[a.length-1];

            if(a[m]!=a[m-1] && a[m]!=a[m+1]) return a[m];
            else if((m%2==1 && a[m]==a[m-1]) || (m%2==0 && a[m]==a[m+1])){  //we are in left half,single element in right, so left-cut
                l=m+1;
            }else{  //right half
                h=m-1;
            }
        }
        return -1;
    }

}
