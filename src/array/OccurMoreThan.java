package com.pranav.striver_dsa_sheet.arraymedium;

import java.util.HashMap;
import java.util.Map;

public class OccurMoreThan {
    public static void main(String[] args) {
        OccurMoreThan obj=new OccurMoreThan();
        int[] num={3,2,3};
//        int[] num={2,2,1,1,1,2,2};
//        obj.occur_bruteforce(num);
//        obj.occur_map(num);

        obj.moore_voting_algo(num);
    }

    void occur_bruteforce(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]!= Integer.MIN_VALUE){
                int count=0;
                for(int j=0;j<a.length;j++){
                    if(a[i] == a[j]){
                        count++;
                        if(i!=j){
                            a[j]=Integer.MIN_VALUE;
                        }
                    }
                }
                if(count>a.length/2){
                    System.out.println(a[i]);
                    return;
                }
            }
        }
    }


    void occur_map(int[] a){
        HashMap<Integer, Integer> freqMap=new HashMap<>();
        for(Integer i:a){
            int found=freqMap.getOrDefault(i,0);
            freqMap.put(i, found+1);
        }


        for(Map.Entry<Integer, Integer> kv: freqMap.entrySet()){
            if(kv.getValue()>a.length/2){
                System.out.println(kv.getKey());
                return;
            }
        }
    }

    void moore_voting_algo(int[] a){
        int c=0;
        int el=a[0];
        for(int i=0;i<a.length;i++){
            if(c==0){
                c=1;
                el=a[i];
            }
            else if(el==a[i])c++;
            else c--;
        }
        int cnt=0;
        for(int i=0;i<a.length;i++){
            if(el==a[i]) cnt++;
        }
        if(cnt>a.length/2) System.out.println(el);
        else System.out.println("no such element");
    }


}
