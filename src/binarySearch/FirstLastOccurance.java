package com.pranav.striver_dsa_sheet.binarysearch1D;

public class FirstLastOccurance {

    public static void main(String[] args) {
        int[] a={1,3,3,3,4,5,7,7,8,11,15};

        int res1=firstOccurance(a, 1);
        int res2=lastOccurance(a, 1);

        int noOfOccurances=res2-res1+1;

        System.out.println(noOfOccurances);
        System.out.println(res1);
        System.out.println(res2);


    }

    static int firstOccurance(int[] a, int tar){
        int l=lb(a, tar); // 0, x , l-1, l
        if(l==a.length || a[l]!=tar)return -1;
        else return l;
    }

    static int lastOccurance(int[] a, int tar){
        int u=ub(a, tar);
//        System.out.println(u);
        if(a[u-1]!=tar) return -1;
        else return u-1;
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

    static int ub(int[] a, int tar){
        int l=0, h=a.length-1, ans=a.length;
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
