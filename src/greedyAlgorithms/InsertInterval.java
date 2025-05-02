package greedyAlgorithms;

public class InsertInterval {
    // public int[][] insert(int[][] intervals, int[] newInterval) {
    //     int i=0, n=intervals.length;
    //     int[] new1=newInterval;
    //     List<int[]> ans=new ArrayList<>();
    //     for(i=0;i<n;i++){
    //         if(new1[0]>=intervals[i][0] && new1[0]<=intervals[i][1]){
    //             int start=intervals[i][0];
    //             int j=i;
    //             while(j<n && new1[1]>=intervals[j][0] && new1[1] >= intervals[j][1]){
    //                 j++;
    //             }
    //             int end=intervals[j][1];
    //             i=j+1;
    //             ans.add(new int[]{start, end});
    //         }
    //         if(i<n)ans.add(intervals[i]);
    //     }
    //     return ans.toArray(new int[ans.size()][]);
    // }


    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0, n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        while(i<n && newInterval[0]>intervals[i][1]){
            ans.add(intervals[i]);
            i++;
        }
        // while(i<n && newInterval[0]<intervals[i][1]){
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);

        while(i<n && newInterval[1]<intervals[i][0]){
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
