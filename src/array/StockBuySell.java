package com.pranav.striver_dsa_sheet.arraymedium;

public class StockBuySell {
    public static void main(String[] args) {
        StockBuySell obj=new StockBuySell();
//        int[] a={7,1,5,3,6,4};
//        int[] a={7,6,4,3,1};
        int[] a={3,7,1,2};
        obj.stockBuySell_bruteForce(a);
        obj.stockBuySell_optimised(a);
    }

    void stockBuySell_bruteForce(int[] a){
        int profit=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                int diff=a[j]-a[i];
                profit=Math.max(diff, profit);
            }
        }
        if(profit<=0) System.out.println("no profit");
        else System.out.println(profit);
    }

    void stockBuySell_optimised(int[] a){//har ek price ke liye min-val and max-profit calculate kar rahe hian......na ke min-price choose kar ke profit nikal rahe hain
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;
        for(int i=0;i<a.length;i++){
            minPrice=Math.min(minPrice, a[i]);
            int profit=a[i]-minPrice;
            maxProfit=Math.max(profit, maxProfit);
        }
        System.out.println(maxProfit);
    }
}
