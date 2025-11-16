class ListNode { 
    int val;
    ListNode next;
    ListNode(int val){
    this.val=val;
    }
}
class Solution {
    public ListNode reversenodesinkgrp(ListNode head,int k){
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy,curr = dummy,next = dummy;
        int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }
        while(count>=k){
            curr=prev.next;
            next=curr.next;
            for (int i=1;i<k;i++){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
            prev=curr;
            count-=k;
        }
        return dummy.next;
    }
}
public class reversenodesinkgrp{
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        Solution sol=new Solution();
        ListNode ans =sol.reversenodesinkgrp(head,2);
        while(ans != null){
            System.out.print(ans.val+" ");
            ans=ans.next;
        }
    }
}