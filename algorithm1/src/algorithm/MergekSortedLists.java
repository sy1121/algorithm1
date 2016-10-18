package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;


public class MergekSortedLists {

	/* public ListNode mergeKLists(ListNode[] lists) {
	     if(lists.length==0) return null;
			 ListNode result=lists[0];
			 for(int i=1;i<lists.length;i++){
				result=merge2Lists(result,lists[i]);
			 }
			return result;
		        
		    }
		 
		 public ListNode merge2Lists(ListNode one,ListNode two){
			 ListNode temp;
			 ListNode nextNode;
			 ListNode preNode = null;
			 ListNode result=one;
			 if(null==two||null==one) return null;
			 		
			 while(null!=two){
	        	
	        	 if(null==one&&null!=preNode){
					 preNode.next=two;
					 break;
					 }

				 if(one.val<two.val){
					 preNode=one;
					 one=one.next;
				 }
				 else {
					 nextNode=two.next;
					 two.next=one;
					 if(null!=preNode)
					 preNode.next=two;
					 else 
						result=two;
	                 preNode=two;
					 two=nextNode;
				 }

				 
			 }
			   
		       return result;
		 }*/
		 
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode  rNode=new ListNode(0),tempNode=rNode;
        int len=lists.length;
        if(len<1) return rNode.next;
        else if(len<2) return lists[0];
        PriQueue pq=new PriQueue(len);
        for(int i=0;i<len;i++){
             if(lists[i]!=null)
      	  pq.Add(lists[i]);
        }
   /*     if(!pq.isEmpty()){
        ListNode head=pq.poll();
        rNode=new ListNode(head.val);
        if(head.next!=null)
        pq.Add(head.next);
         tempNode=rNode;
        }*/
        while(!pq.isEmpty()){
      	 ListNode minNode=pq.poll();
      	 tempNode.next=new ListNode(minNode.val);
      	 tempNode=tempNode.next;
           if(minNode.next!=null)
          	 pq.Add(minNode.next);
        }
        return rNode.next;
  } 
 public class  PriQueue{
	   ListNode[] element;
	   int size;
	   public PriQueue(int size){
		   element=new ListNode[size];
		   this.size=0;
	   }
	   
	   public void  Add(ListNode value){
		   if(this.size>element.length-1) return;
		   else if(this.size==0) element[0]=value;
		   else{
			   int i=this.size-1;
			   for(;i>=0;i--){
				   if(element[i].val<value.val){
					   element[i+1]=element[i];
				   }else{
					   break;
				   }
			   }
			   element[i+1]=value;
		   }
		   this.size++;
	   }
	   
	   public ListNode poll(){
		     return element[--this.size];
	   }
	   
	   public boolean isEmpty(){
		   return this.size==0;
	   }
	   
	   public boolean isFull(){
		   return this.size==element.length;
	   }
 
   }
	 
	 public static void main(String [] arg){
		 MergekSortedLists ml = new MergekSortedLists();
		 ListNode one=new ListNode(0),two=new ListNode(0),three=new ListNode(0);
		 ListNode temOne=one;
		 ListNode temTwo=two;
		 ListNode temThree=three;
		// Random r = new Random(100);
		 for(int i=0;i<10;i++){
			 one.val=i*2+1;
			 one.next=new ListNode(0);
			 one=one.next;
		 }
		 
		 for(int i=0;i<10;i++){
			 two.val=i*i+1;
			 two.next=new ListNode(0);
			 two=two.next;
		 }
		 
		 for(int i=0;i<10;i++){
			 three.val=3*i-1;
			 three.next=new ListNode(0);
			 three=three.next;
		 }
		 
		 ListNode rlist=ml.mergeKLists(new ListNode[]{temOne, temTwo,temThree});
		 while(null!=rlist.next){
			 System.out.println(rlist.val);
			 rlist=rlist.next;
		 }
		
	 }
}
