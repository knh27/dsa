package com.pranav.striver_dsa_sheet.arrayeasy;

public class ConsecutiveOnes {
    public static void main(String[] args) {
        int[] a={1,0,1,1,1,1,1,0,0,1,1,1,1};
        ConsecutiveOnes obj=new ConsecutiveOnes();
        obj.consecutiveOnes(a);

    }

    void consecutiveOnes(int[] a){
        int count=0, maxOnes=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==1){
                count++;
            }else{
                count=0;
            }
            maxOnes=Math.max(count, maxOnes);
        }
        System.out.println(maxOnes);
    }
}
