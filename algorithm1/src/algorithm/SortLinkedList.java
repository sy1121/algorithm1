package algorithm;

import java.util.Random;

public class SortLinkedList {
	 public ListNode sortList(ListNode head) {
		 if(null==head) return null;
		 while(head.val!=0){
		 head=sort(head);
		 }
		 return head;
	    }
	 
	 public ListNode sort(ListNode head){
		 ListNode rNode=head;
		 int temp;
		 int count=0;
		 while(null!=head.next){
			 if(head.val>head.next.val){
				temp=head.val;
				head.val=head.next.val;
				head.next.val=temp;
			 }
			 head=head.next;
			 count++;
		 }

		 return rNode;
	 }
	public static void main(String [] args){
		 SortLinkedList sll = new SortLinkedList();
		 ListNode ln=new ListNode(0);
		 ListNode lnn=ln;
		 Random r=new Random(100);
		 for(int i=0;i<10;i++){
			 ln.val=r.nextInt(100);
			 ln.next=new ListNode(0);
             ln=ln.next;             
		 }
		 ListNode rListNode=sll.sortList(lnn);
		 while(null!=rListNode){
			 System.out.println(rListNode.val);
			 rListNode=rListNode.next;
		 }
	 }
	 
	 
}
