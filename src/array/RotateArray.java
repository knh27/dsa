package com.pranav.striver_dsa_sheet.arrayeasy;

public class RotateArray {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,8};
        int k=2;
        int n=a.length;
        k=k%n;

        RotateArray obj=new RotateArray();
        obj.rev(a,0,n-1-k);
        obj.rev(a,n-k,n-1);
        obj.rev(a,0,n-1);

        for(Integer i:a) System.out.print(i);

    }
    void rev(int[] a, int i, int j){
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
}
