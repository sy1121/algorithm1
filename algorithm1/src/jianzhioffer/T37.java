package jianzhioffer;

import algorithm.ListNode;

/**
 * 两个链表的公共节点
 * @author sy
 *
 */
public class T37 {
    public ListNode firstCommonNode(ListNode head1,ListNode head2){
         ListNode phead1=head1,phead2=head2;
         int l1=getLength(head1),l2=getLength(head2);
         ListNode llist=head1,slist=head2;
         int dif=l1-l2;
         if(dif<0){
        	 llist=head2;
        	 slist=head1;
        	 dif=-dif;
         }
         
         
         while(dif>0){
        	 llist=llist.next;
        	 dif--;
         }
         while(llist!=null&&slist!=null&&llist!=slist){
        	llist=llist.next;
        	slist=slist.next;
         }
         
         return llist;
    }
    
    private int getLength(ListNode head){
    	int result=0;
    	while(head!=null){
    		head=head.next;
    		result++;
    	}
    	return result;
    }
}
