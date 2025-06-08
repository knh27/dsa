package recursionBacktracking;
import java.util.*;

public class IfSubsequnceSumEqualsTarget {
    static Boolean f_dp(int i, int tar, Boolean[][]dp, int[] a){
        if(i<0){
            if(tar!=0) return false;
            else return true;
        }
        if(tar==0) return true;

        if(dp[i][tar]!=null) return dp[i][tar];

        boolean notPick=f_dp(i-1, tar,dp, a);
        boolean pick=false;
        if(tar>=a[i])pick=f_dp(i-1, tar-a[i], dp, a);
        return dp[i][tar]= (pick || notPick);

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


    static boolean f2(int i, int tar, int[] a){
        if(i<0){
            if(tar!=0) return false;
            else return true;
        }
        if(tar==0) return true;
        boolean notPick=f2(i-1, tar, a);
        boolean pick=false;
        if(tar>=a[i])pick=f2(i-1, tar-a[i], a);
        return pick || notPick;

    }


    public static void main(String[] args) {
        int[]a={2,3,4,1};
        int tar=10;
        System.out.println(f2(3, tar, a));
//        System.out.println(f(3, tar, a));

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
