package greedyAlgorithms;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int i=0, fives=0, tens=0, twen=0;
        while(i<bills.length){
            if(bills[i]==5){
                fives+=1;
            }
            else if(bills[i]==10){
                if(fives>=1){
                    fives-=1;
                    tens++;
                }
                else return false;

            }
            else{
                if(tens>=1 && fives>=1){
                    tens--;
                    fives--;
                }
                else if(fives>=3){
                    fives-=3;
                }
                else return false;
            }
            i++;
        }
        return true;

    }
}
