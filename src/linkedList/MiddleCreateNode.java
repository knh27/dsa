package com.pranav.striver_dsa_sheet.linklistmedium;

public class MiddleCreateNode {
    private static Node head=null,tail=null;
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        Node myHead=createList_arr(a);

    }
    static void middle(Node head){
        Node fast=head,slow=head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.val);

    }

    static Node createList_loop(Node n){
        if(head==null){
            head=n;
            n.next=null;
            return head;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        n.next=null;
        return head;
    }
    static Node createList_optimal(Node n){
        if(head==null){
            head=n;
            tail=n;
            n.next=null;
            return head;
        }
        tail.next=n;
        tail=n;
        return head;
    }

    static Node createList_arr(int[] a){
        for(Integer val:a){
            Node n=new Node(val);
            if(head==null){
                head=n;
                tail=n;
                n.next=null;
            }else{
                tail.next=n;
                tail=n;
            }
        }
        return head;
    }

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val=val;
            this.next=null;
        }
    }

}
