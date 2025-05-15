package com.pranav.striver_dsa_sheet.arrayeasy;

public class SecondLargestElement {
    public static void main(String[] args) {
        SecondLargestElement obj=new SecondLargestElement();
        obj.secondLargest();

    }
    public void secondLargest(){
        int[] arr={3,3,3,3,3};
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int i=0;i<5;i++){
            if(arr[i]>max){
                secMax=max;
                max=arr[i];
            }else if(arr[i]!=max && arr[i]>secMax){
                secMax=arr[i];
            }
        }
        System.out.println("second largest:"+secMax);
        System.out.println("largest:"+max);

    }
}
