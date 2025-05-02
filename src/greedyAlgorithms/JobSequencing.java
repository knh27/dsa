package greedyAlgorithms;
import java.util.*;

public class JobSequencing {
    class Job{
        int id;
        int deadline;
        int profit;

        Job(int id, int deadline, int profit){
            this.id=id;
            this.deadline=deadline;
            this.profit=profit;
        }
    }
    public int[] JobScheduling(int[][] Jobs) {
        //your code goes here

        int row=Jobs.length;
        int col=Jobs[0].length;

        Job[] a=new Job[row];

        for(int i=0;i<row;i++){
            a[i]=new Job(Jobs[i][0], Jobs[i][1], Jobs[i][2] );
        }

        // Array.sort(a, profit);
        Arrays.sort(a, (x, y) -> y.profit - x.profit);

        int maxDeadline=0;
        for(int i=0;i<row;i++){
            maxDeadline=Math.max(maxDeadline,a[i].deadline );
        }
        int[] days=new int[maxDeadline];
        //  Arrays.fill(days, -1); // -1 means unoccupied
        for(int i=0;i<maxDeadline;i++){
            days[i]=-1;
        }

        int c=0; int profits=0;
        for(int i=0;i<row;i++){
            int day=a[i].deadline;
            for(int j=day;j>0;j--){
                if(days[j-1]==-1){
                    days[j-1]=a[i].id;
                    c++;
                    profits=profits+a[i].profit;
                    break;

                }
            }


        }


        return new int[]{c, profits};

    }




}
