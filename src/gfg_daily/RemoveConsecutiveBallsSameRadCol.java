package gfg_daily;
import java.util.*;

public class RemoveConsecutiveBallsSameRadCol {
    public int findLength(int[] color, int[] radius) {
        // code here
        int ans=color.length;
        int n=color.length;
        List<Integer> colL=new ArrayList<>();
        List<Integer> radL=new ArrayList<>();
        for(int k=0;k<n;k++){
            int i=k;
            boolean flag=false;
            colL.add(color[k]);
            radL.add(radius[k]);
            while(i<n && i+1<n&&color[i]==color[i+1]&&radius[i]==radius[i+1]){
                i++;
                flag=true;
            }
            if(flag)ans-=i-k+1;
            k=i+1;

        }
        for(int it:colL){
            System.out.println(it);
        }
        return ans;
    }


    public static void main(String[] args) {
        RemoveConsecutiveBallsSameRadCol obj=new RemoveConsecutiveBallsSameRadCol();
        int[] col={1, 1, 1};
        int[] rad={2, 2, 2};

        System.out.println(obj.findLength(col,rad));
    }
}
