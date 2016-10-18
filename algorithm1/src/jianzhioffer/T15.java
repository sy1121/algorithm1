package jianzhioffer;

import sort.Node;
import algorithm.ListNode;

/**
 * 找到链表中的倒数第k元素
 * @author sy
 *
 */

public class T15 {
    public ListNode findKthToTail(ListNode head,int k){
    	  if(head==null||k==0) return  null;
    	  int len=getLength(head);
    	  k=k%len;
    	  ListNode fast=head,slow=head;
    	  while(k>0){
    		  fast=fast.next;
    		  k--;
    	  }
    	  while(fast!=null){
    		  fast=fast.next;
    		  slow=slow.next;
    	  }
    	  return slow;
    }
    private int getLength(ListNode head){
    	int result=0;
    	while(head!=null){
    	   result++;
    	   head=head.next;
    	}
    	return result;
    }
    
    public static void main(String[] args){
    	T15 t=new T15();
    	ListNode[] nodes=new ListNode[6];
    	for(int i=0;i<nodes.length;i++){
    		nodes[i]=new ListNode(i+1);
    	}
    	for(int i=0;i<nodes.length-1;i++){
    		nodes[i].next=nodes[i+1];
    	}
        ListNode r=t.findKthToTail(nodes[0],3);
        System.out.println(r.val);
    }
}
