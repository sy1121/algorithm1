package algorithm;

public class RemoveNthNodeFromEndofList19 {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public ListNode removeNthFromEnd(ListNode head, int n) {   
		    if(n<1) return head;
		    ListNode fast=head,slow=head,pre=null;
	        for(int i=0;i<n;i++){
	         if(fast==null) return head.next;
	         fast=fast.next;
	        }
	        while(fast!=null){
	        	fast=fast.next;
	        	pre=slow;
	        	slow=slow.next;
	        }
	        if(pre!=null) {
	        	pre.next=slow.next;
	        	return head;
	        }else
	        	return head.next;
	        
	    }
}
