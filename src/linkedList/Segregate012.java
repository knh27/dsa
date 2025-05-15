package com.pranav.striver_dsa_sheet.linklistmedium;

public class Segregate012 {
    public static void main(String[] args) {

    }

    static Node segregate(Node head) {
        Node oneH=new Node(-1);
        Node twoH=new Node(-1);
        Node zeroH=new Node(-1);
        Node temp=head,zeroT=zeroH,oneT=oneH,twoT=twoH;
        while(temp!=null){
            if(temp.data==0){
                zeroT.next=temp;
                zeroT=temp;
            }else if(temp.data==1){
                oneT.next=temp;
                oneT=temp;
            }else{
                twoT.next=temp;
                twoT=temp;
            }
            temp=temp.next;
        }
        twoT.next=null;
        oneT.next=twoH.next;
        zeroT.next=oneH.next;
        head=zeroH.next;
        return head;

    }


    static Node segregateOptimised(Node head) {
        if (head == null || head.next == null) return head;
        int count[] = {0, 0, 0};
        Node temp = head;

        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }

        temp = head;
        int i = 0;
        while (temp != null) {
            if (count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                count[i]--;
                temp = temp.next;
            }
        }
        return head;
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
}
