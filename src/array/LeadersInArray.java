package com.pranav.striver_dsa_sheet.arraymedium;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr={13, 6, 8, 2, 5, 3, 4, 1};
        ArrayList<Integer> ans=new ArrayList<>();
            int greatest=Integer.MIN_VALUE;
            for(int i=arr.length-1;i>=0;i--){
               Boolean flag=false;
               if(arr[i]>greatest){
                   greatest=Math.max(greatest, arr[i]);
                   flag=true;
               }

               if(flag)ans.add(arr[i]);
           }

        for(Integer el:ans){
            System.out.print(el+" ");
        }
    }



}
