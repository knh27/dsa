package greedyAlgorithms;
import java.util.*;
public class MaxMeetingInRoom {
    class MeetTime{
        int start;
        int end;
        MeetTime(int start, int end){
            this.start=start;
            this.end=end;
        }
    }
    public int maxMeetings(int[] start, int[] end) {
        //your code goes here
        int n=start.length;
        MeetTime[] a=new MeetTime[n];
        for(int i=0;i<n;i++){
            a[i]=new MeetTime(start[i], end[i]);
        }
        Arrays.sort(a, (x, y)->x.end-y.end);
        int c=1;
        int lastTime=a[0].end;
        for(int i=1;i<n;i++){
//            while(i<n-1 && a[i].end>a[i+1].start){
//                i++;
//            }
//            c+=2;
//            if(a[i].end<a[i+1].start){
//                c+=2;
//            }
            if(a[i].start>lastTime){
                c++;
                lastTime=a[i].end;

            }
        }
        return c;

    }

    public static void main(String[] args) {
        int[]  Start = {1, 3, 0, 5, 8, 5} , End = {2, 4, 6, 7, 9, 9};
        MaxMeetingInRoom obj=new MaxMeetingInRoom();
        System.out.println(obj.maxMeetings(Start, End));


    }
}
