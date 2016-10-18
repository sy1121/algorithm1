package algorithm;

public class AddTwoNumbers2 {
	//AC 4ms
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	         ListNode resultNode=new ListNode(0);
	         ListNode tempNode=resultNode;
	         int sign=0;
	         int sum;
	         while(l1!=null||l2!=null){
	        	 sum=0;
	        	 if(l1!=null){
	        		 sum+=l1.val;
	        		 l1=l1.next;
	        	 }
	        	 if(l2!=null){
	        		 sum+=l2.val;
	        		 l2=l2.next;
	        	 }
	        	 sum+=sign;
	        	 ListNode newNode=new ListNode(sum%10);
	        	 tempNode.next=newNode;
	        	 tempNode=tempNode.next;
	        	 sign=sum/10;
	         }
	         if(sign!=0){
	        	 ListNode newNode=new ListNode(sign);
	        	 tempNode.next=newNode;
	         }
	         return resultNode.next;
	    }
	
}
