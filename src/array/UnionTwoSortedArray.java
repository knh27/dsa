package com.pranav.striver_dsa_sheet.arrayeasy;

import java.util.ArrayList;
import java.util.List;

public class UnionTwoSortedArray {
    public static void main(String[] args) {
        UnionTwoSortedArray obj=new UnionTwoSortedArray();
        int[] a={1,1,2,3,3,4,5,5};
        int[] b={2,2,3,4,4,5};
        obj.unionOfTwoArray(a,b);

    }

    public void unionOfTwoArray(int[] a, int[] b){
        int i=0,j=0;
        List<Integer> union=new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]){
                if(union.isEmpty() || union.get(union.size()-1) != a[i]){
                    union.add(a[i]);
                }
                i++;

            }else{
                if(union.isEmpty() || union.get(union.size()-1) != b[j]){
                    union.add(b[j]);
                }
                j++;
            }

        }

        while(i<a.length){
            if(union.isEmpty() || union.get(union.size()-1) != a[i]){
                union.add(a[i]);
            }
            i++;
        }

        while(j<b.length){
            if(union.isEmpty() || union.get(union.size()-1) != b[j]){
                union.add(b[j]);
            }
            j++;
        }

        for(Integer val:union){
            System.out.print(val);
        }
    }

}
