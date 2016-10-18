package algorithm;

public class SortList148 {
	 public ListNode sortList(ListNode head) {
		      if(head==null||head.next==null) return head;
	          ListNode  slow=head,fast=head,pre=head;
	          while(fast!=null&&fast.next!=null){
	              pre=slow;
	        	  slow=slow.next;
	        	  fast=fast.next.next;
	          }
	          pre.next=null;
	          ListNode node1=sortList(head);
	          ListNode node2=sortList(slow);
	          return mergeSort(node1,node2);
	          
	    }
	 
	 private ListNode mergeSort(ListNode node1,ListNode node2){
		 ListNode temp=new ListNode(0),result=temp;  
		 while(node1!=null&&node2!=null){
			 if(node1.val<node2.val) {
			   temp.next=node1;
			    node1=node1.next;
			 }else{
				 temp.next=node2;
				 node2=node2.next;
			 }
			 temp=temp.next;
		 }
		 if(node1==null&&node2!=null) temp.next=node2;
		 else if(node2==null&&node1!=null) temp.next=node1;
		 return result.next;
	 }
	 
	 public static void main(String[] args){
		 SortList148 s=new SortList148();
		 ListNode node1=new ListNode(3);
		 ListNode node2=new ListNode(4);
		 ListNode node3=new ListNode(2);
		 ListNode node4=new ListNode(1);
		 ListNode node5=new ListNode(4);
		 ListNode node6=new ListNode(16);
		 ListNode node7=new ListNode(14);
		 ListNode node8=new ListNode(6);
		 node1.next=node2;
		 node2.next=node3;
		 node3.next=node4;
		 node4.next=node5;
		 node5.next=node6;
		 node6.next=node7;
		 node7.next=node8;
		 
		 ListNode r=s.sortList(node1);
		 while(r!=null){
			 System.out.println(r.val);
			 r=r.next;
		 }
	 }
}
