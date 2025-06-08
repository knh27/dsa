package recursionBacktracking;
import java.util.*;

public class IfSubsequnceSumEqualsTarget {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int[] dp=new int[arr.length];
        Arrays.fill(dp, -1);

        if(f(arr, 0, 0, sum)){
            return true;
        }
        else{
            return false;
        }

    }


    static Boolean f(int[] a, int i, int curSum, int tar){
        if(curSum==tar) return true;
        if(i==a.length) return false;

        boolean pick=f(a, i+1, curSum+a[i], tar);
        if(pick) return true;
        boolean notPick=f(a, i+1, curSum, tar);
        if(notPick) return true;
        return pick||notPick;
    }





    // static Boolean f(int[] a, int ind, int sum, int tar){
    //     if(sum==tar){
    //         return true;
    //     }
    //     else if(ind==a.length-1){
    //         if(sum==tar) return true;
    //         else return false;
    //     }

    //     int pick=sum+a[ind];
    //     if(f(a,ind+1, pick, tar)){
    //         return true;
    //     }
    //     int notPick=sum;
    //     if(f(a, ind+1, notPick, tar)){
    //         return true;
    //     }

    //     return false;
    // }
}
