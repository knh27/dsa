package com.pranav.striver_dsa_sheet.arrayeasy;

import java.util.HashMap;
import java.util.Map;

public class AppearOneTime {
    public static void main(String[] args) {
        AppearOneTime obj=new AppearOneTime();
//        int[] a={6,1,4,2,1,5,2,6,4,1};
//        int[] a={4,1,2,1,2};
        int[] a={2,2,1};
//        obj.AppearOneTime_bruteForce(a);
//        obj.AppearOneTime_betterApproach(a);

        obj.appearOnce(a);

    }

    void AppearOneTime_bruteForce(int[] a){

        for(int i=0;i<a.length;i++){
            Boolean flag=false;
            if(a[i] != Integer.MIN_VALUE){
                for(int j=0;j<a.length;j++){
                    if(a[i]==a[j]){
                        flag=true;
                        if(i!=j){
                            a[j]=Integer.MIN_VALUE;
                        }
                    }

                }
                if(!flag) {
                    System.out.println(a[i]);
                    break;
                }

            }
        }
    }

    void AppearOneTime_betterApproach(int[] a){
        Map<Integer, Integer> myMap=new HashMap<>();
        for(Integer i:a){
            myMap.put(i, myMap.getOrDefault(i,0)+1);
        }
//        for(Map.Entry<Integer, Integer> i:myMap.entrySet()){
//            System.out.println(i);
//        }
        for(Map.Entry<Integer, Integer> i:myMap.entrySet()){
            if(i.getValue()==1){
                System.out.println(i.getKey());
            }
        }
    }


    //commented is incorrect code as it doesnot handle case if last element of an array is an unique element and you uses flag=false and then make it true, so better to make flag=true initially


    void appearOnce(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]!=Integer.MIN_VALUE){
                Boolean flag=true;
                for(int j=i+1;j<a.length;j++){
                    if(a[i]==a[j]){
                        flag=false;
                        a[j]=Integer.MIN_VALUE;
                    }
                }
                if(flag){
                    System.out.println(a[i]);
                    return;
                }
            }
        }
    }
}
