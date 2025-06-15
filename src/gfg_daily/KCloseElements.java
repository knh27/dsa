package gfg_daily;
import java.util.*;

/*

K closest elements
Difficulty: MediumAccuracy: 15.96%Submissions: 74K+Points: 4Average Time: 30m
You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly k elements from the array closest to x, excluding x if it exists.

An element a is closer to x than b if:


a - x| < |b - x|, or
|a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)


Return the k closest elements in order of closeness

*/
public class KCloseElements {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        int l=0, r=arr.length-1, ind=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(x==arr[m]){
                ind=m;
                break;
            }
            else if(x<arr[m]){
                r=m-1;
            }
            else l=m+1;
        }

        int li, ri;
        if (ind != -1) {
            li = ind - 1;
            ri = ind + 1;
        } else {
            li = l - 1;
            ri = l;
        }

        ArrayList<Integer> ans=new ArrayList<>();

        // int ri=ind+1, li=ind-1;

        int n=arr.length;
        for(int i=0;i<k;i++){
            if(ri>=n){
                if(li>=0)ans.add(arr[li--]);
            }

            else if(li<0){
                if(ri<=n-1)ans.add(arr[ri++]);
            }

            else if(li>=0&&ri<=n-1){
                int rd=Math.abs(arr[ri]-x);
                int ld=Math.abs(arr[li]-x);

                if (ld < rd) {
                    ans.add(arr[li--]);
                } else if (rd < ld) {
                    ans.add(arr[ri++]);
                } else {
                    // Tie-breaker: choose larger value
                    if (arr[li] > arr[ri]) {
                        ans.add(arr[li--]);
                    } else {
                        ans.add(arr[ri++]);
                    }
                }
            }
        }
        int[] ansArr=new int[ans.size()];
        for(int i=0;i<ansArr.length;i++){
            ansArr[i]=ans.get(i);
        }
        return ansArr;

    }
}
