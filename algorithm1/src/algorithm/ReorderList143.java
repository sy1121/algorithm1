package algorithm;

public class ReorderList143 {
	 public void reorderList(ListNode head) {
		  if(head==null) return ;
	       int size=0;
	       ListNode thead=head;
	       while(thead!=null){
	    	   size++;
	    	   thead=thead.next;
	       }
	       int right=(size+1)/2+1;
	       ListNode rightStartNode;
	       thead=head;size=1;
	       while(size!=right-1){
	    	   thead=thead.next;
	    	   size++;
	       }
	       rightStartNode=thead.next;
	       thead.next=null;
	       rightStartNode=reverse(rightStartNode);
	       ListNode result=head;
	       while(head!=null&&rightStartNode!=null){
	    	  ListNode nextHead=head.next;
	    	  ListNode nextRight=rightStartNode.next;
	    	  head.next=rightStartNode;
	    	  rightStartNode.next=nextHead;
	    	  head=nextHead;
	    	  rightStartNode=nextRight;
	       }
	        head=result;
	    }
	 
	 public ListNode reverse(ListNode head){
		 ListNode pre=null,thead=head;
		 while(thead!=null){
			  ListNode nextNode=thead.next;
			  thead.next=pre;
			  pre=thead;
			  thead=nextNode;
		 }
		 return pre;
	 }
	 
	 public static void main(String[] args){
		 ReorderList143 r=new ReorderList143();
		 ListNode node1=new ListNode(1);
		 ListNode node2=new ListNode(2);
		 ListNode node3=new ListNode(3);
		 ListNode node4=new ListNode(4);
		 ListNode node5=new ListNode(5);
		 ListNode node6=new ListNode(6);
		 ListNode node7=new ListNode(7);
		// ListNode node8=new ListNode(8);
		 node1.next=node2;
		 node2.next=node3;
		 node3.next=node4;
		 node4.next=node5;
		 node5.next=node6;
		 node6.next=node7;
		// node7.next=node8;
		 r.reorderList(null);
		 while(node1!=null){
			 System.out.print(node1.val+"-->");
			 node1=node1.next;
		 }
	 }
}
