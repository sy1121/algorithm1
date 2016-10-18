package algorithm;

public class LinkedListCycleII142 {
	 static  class   ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	 
	 //AC 1ms
	 public ListNode detectCycle(ListNode head) {
	        ListNode fast=head,slow=head;
	        int count=0;
	        boolean flag=false; 
	        while(fast!=null&&fast.next!=null){
	            fast=fast.next.next;
	            slow=slow.next;
	            count++;
	            if(fast==slow) {
	               flag=true;break;
	            }
	        }
	        if(flag){
	          ListNode fast1=head,slow1=head;
	          while(count-->0) 
	        	  fast1=fast1.next;
	          while(fast1!=slow1){
	               fast1=fast1.next;
	               slow1=slow1.next;
	          }
	          return fast1;
	       }else return null;
	        
	    }
	 
	 public static void main(String[] args){
		 LinkedListCycleII142 l=new LinkedListCycleII142();
		 ListNode head=new ListNode(1);
		 ListNode node1=new ListNode(2);
		 head.next=node1;
		 node1.next=head;
		 ListNode rNode=l.detectCycle(head);
		 System.out.println("result="+rNode.val);
		 
	 }
}
