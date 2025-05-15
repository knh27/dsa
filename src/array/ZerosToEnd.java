package com.pranav.striver_dsa_sheet.arrayeasy;

public class ZerosToEnd {
    public static void main(String[] args) {
        ZerosToEnd obj=new ZerosToEnd();

//        int[] arr={1,2,4,2,0,5,0,0,0,8,0,0,6,4,0};
        int[] arr={0,0,0,1,2,0,1,0,4,0};
        obj.moveZerosEnd(arr);
    }

    public void moveZerosEnd(int[] arr){
        int i=0;int n=arr.length;
        while(i<n && arr[i]!=0)i++;
        int j=i+1;
        while(j<n){
            while(j<n && arr[j]==0)j++;
            if(j<n){

                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                i++;
            }
            j+=1;
        }

        for(int k:arr){
            System.out.print(k);
        }
    }

    void zerosToEnd_noOrder(int[] a){
        int l=0,r=a.length-1;
        while(l<r){
            while(l<r && a[r]==0)r++;
            while(l<r && a[l]!=0)l++;
            if (l < r) {
                int temp=a[l];
                a[l]=a[r];
                a[r]=temp;
                l++;
                r--;
            }

        }
    }

    void zerosToEnd_order(int[] a){
        int i=0;int j=i+1;
        while(j<a.length){
            while(j<a.length && a[i] != 0)i++;
            while(j<a.length && a[j]==0)j++;
            if(j<a.length){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j++;
            }
        }
    }


    //below code is correct but order is not maintained
    void zerosToEnd_noOrder2(int[] a){
        int l=0,h=a.length-1;
        while(l<=h){
            if(a[l]==0 && a[h]!=0){
                int temp=a[l];
                a[l]=a[h];
                a[h]=temp;
                h--;
                l++;
            }
            else if(a[h]==0)h--;
            else if(a[l]!=0)l++;
        }
    }


    //below code is correct
    void zeroToEnd_order2(int[] a){
        int i=0, j=i+1;
        while(j<a.length){
            if(a[i]==0 && a[j]!=0){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                j++;
                i++;
            }
            else if(a[i]!=0){
                i++;
                j++;
            }
            else if(a[j]==0)j++;
        }
    }
}









