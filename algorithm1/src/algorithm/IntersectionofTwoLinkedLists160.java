package algorithm;

public class IntersectionofTwoLinkedLists160 {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	 }
	 
	 //AC 2ms
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		    if(headA==null||headB==null) return null;
	        ListNode  tailA=null,tailB=null,tempA=headA,tempB=headB;
	        int sizeA=1,sizeB=1;
	        while(tempA.next!=null){
	            tempA=tempA.next;
	            sizeA++;
	        }
	        tailA=tempA;
	        while(tempB.next!=null){
	        	tempB=tempB.next;
	        	sizeB++;
	        }
	        tailB=tempB;
	        if(tailA!=tailB) return null;
	        else{
	          int diff=sizeA>sizeB?sizeA-sizeB:sizeB-sizeA;
	          ListNode A=headA,B=headB;
	          if(sizeA>sizeB){
	        	  while(diff>0){
	        		  A=A.next;
	        		  diff--;
	        	  }
	          }else{
	        	  while(diff>0){
	        		  B=B.next;
	        		  diff--;
	        	  }
	          }
	          while(A!=null){
	             if(A==B){
	            	 return A;
	             }else{
	            	 A=A.next;
	            	 B=B.next;
	             }
	        }
	        return null;
	    }
	}
}
