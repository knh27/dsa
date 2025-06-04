package patterns;

public class Pattern1 {

    private void pattern1(int n){
        int row=2*n-1;
        int val=n;
        int[][]a=new int[row][row];
        for(int k=0;k<n;k++){
            for(int i=0+k;i<=row-1-k;i++){
                a[row-1-k][i]=val;
                a[i][row-1-k]=val;
                a[k][i]=val;
                a[i][k]=val;
            }
            val--;
        }

        for(int[] x:a){
            for(int y:x){
                System.out.print(y);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Pattern1 obj=new Pattern1();
        obj.pattern1(3);
    }
}
