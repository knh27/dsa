package greedyAlgorithms;
import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x,y)->x[1]-y[1]);
        int n=intervals.length, c=1;
        if(n==0) return 0;
        int lastVal=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]>=lastVal){
                c++;
                lastVal=intervals[i][1];
            }
        }
        return n-c;
    }
}
