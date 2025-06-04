package com.pranav.striver_dsa_sheet.arrayeasy;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates obj=new RemoveDuplicates();
//        int[] arr={1,1,4,4,4,4,5,6,6,8};
        int[] arr={1,1,1,1,1,1,1,1};
//        int[] arr={1,4,5,6,8,9,66};
//        obj.removeDuplicates(arr);
//        obj.removeDuplicates2(arr);
        obj.removeDuplicates3(arr);
    }

    public void removeDuplicates(int[] arr){
        int i=0; int j=1; int n=arr.length;
        while(j<n){
            if(arr[i]!=arr[j]){
                i+=1;
                arr[i]=arr[j];
            }
            j++;
        }
        System.out.println("new array:");
        for(int k=0;k<=i;k++){
            System.out.print(arr[k]);
        }
    }

    public void removeDuplicates2(int[] arr){
        int i=0,j=1,n=arr.length;
        while(j<n){
            if(j<n&&arr[i]==arr[j]){
                while(j<n&&arr[i]==arr[j]){
                    j++;
                }
                if(j<n)arr[++i]=arr[j];
            }else{
                i++;
                j++;
            }

        }
        for(Integer val:arr) System.out.print(val);
    }


    public void removeDuplicates3(int[] a){
        int i=0,j=1;
        while(j<a.length){
            while(j<a.length && a[i]==a[j]){
                j++;
            }
            if(j<a.length)a[++i]=a[j];//condition is must
            j++;
        }
        for(int ind=0;ind<=i;ind++){
            System.out.print(a[ind]);
        }
    }




}
