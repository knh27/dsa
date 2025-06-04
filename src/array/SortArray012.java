package com.pranav.striver_dsa_sheet.arraymedium;

public class SortArray012 {
    public static void main(String[] args) {
        int[] a={2,1,2,2,1,0,1,0,1};
        SortArray012 obj=new SortArray012();
//        obj.sortArr(a);

        obj.sortArr_dutchFlag(a);
    }

    void sortArr(int[] a){
        int c0=0,c1=0,c2=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0)c0++;
            else if(a[i]==1)c1++;
            else c2++;
        }
        int k=0;
        for(int i=0;i<c0;i++){
            a[k++]=0;
        }for(int i=0;i<c1;i++){
            a[k++]=1;
        }for(int i=0;i<c2;i++){
            a[k++]=2;
        }

        for(Integer item:a) System.out.println(item);
    }

    void sortArr_dutchFlag(int[] a){
        int low=0,mid=0,high=a.length-1;
        while(mid<=high){
            if(a[mid]==0){
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;//we can remove this incresing mid if confused....it wil lead to one extra step
            }else if(a[mid]==1)mid++;
            else{
                int temp=a[high];
                a[high]=a[mid];
                a[mid]=temp;
                high--;
            }

        }
        for(Integer item:a) System.out.print(item);
    }
}
