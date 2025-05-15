package com.pranav.striver_dsa_sheet.arraymedium;

public class AlternatePosNeg {
    public static void main(String[] args) {
        AlternatePosNeg obj=new AlternatePosNeg();
//        int[] a={-2, -5, 4, 3, -1, 5};
        int[] a={1, -2, -3, -4, 5, 6};
//        int[] a = {1, 2, 3, -1, -2, -3};
        obj.altPosNeg(a);
    }

    void altPosNeg(int[] a){
        int pos=0,neg=0;
        for(int i=0;i<a.length;i++){
            while(neg<a.length && a[neg]>0)neg++;
            while(pos<a.length && a[pos]<0)pos++;
            if(i%2==0){
                if(a[i]<0 && pos< a.length){
                    swap(a,i, pos);
                }
                pos++;
            }else{
                if(a[i]>0 && neg< a.length){
                    swap(a, i, neg);
                }
                neg++;
            }
        }
        for(Integer i:a) System.out.print(i+" ");
    }
    void swap(int[] a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
