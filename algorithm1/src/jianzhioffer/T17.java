package jianzhioffer;

import algorithm.ListNode;

/**
 * 合并两个排序链表
 * @author sy
 *
 */
public class T17 {
    public ListNode mergeList(ListNode list1,ListNode list2){
    	 ListNode dummy=new ListNode(0);
    	 ListNode result=dummy;
    	 if(list1==null) dummy.next=list2;
    	 if(list2==null) dummy.next=list1;
    	 while(list1!=null&&list2!=null){
    		 if(list1.val<list2.val){
    			 dummy.next=list1;
                 list1=list1.next;
    		 }else{
    			 dummy.next=list2;
    			 list2=list2.next;
    		 }
    		 dummy=dummy.next;
    		 dummy.next=null;
    	 }
    	 dummy.next=list1==null?list2:list1;
    	 return result.next;
    }
    
    
    public static void main(String[] args){
    	T17 t=new T17();
    	ListNode list1=new ListNode(1);
    	ListNode node1=new ListNode(5);
    	ListNode node2=new ListNode(8);
    	list1.next=node1;
    	node1.next=node2;
    	ListNode list2=new ListNode(2);
    	ListNode node3=new ListNode(4);
    	ListNode node4=new ListNode(10);
    	list2.next=node3;
    	node3.next=node4;
    	ListNode r=t.mergeList(list1, list2);
    	while(r!=null){
    		System.out.print(r.val+" ");
    		r=r.next;
    	}
    }
    
}
