package heap;

public class InsertionInHeap {
    static int[] arr={-1, 55, 54, 53,50,52};
    static void insertInHeap(int val){
        int n=arr.length;
        n=n+1;
        arr[n-1]=val;
        int ind=n-1;
        while(ind>=1){
            int par=ind/2;
            if(arr[par]<arr[ind]){
                int temp=arr[ind];
                arr[ind]=arr[par];
                arr[par]=temp;

                ind=par;
            }
            else break;
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr={-1, 55, 54, 53,50,52};
        insertInHeap(57);
        for(int val:arr){
            System.out.print(val+" ");
        }
    }
}
