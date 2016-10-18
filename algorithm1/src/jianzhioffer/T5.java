package jianzhioffer;

import java.util.Stack;

import algorithm.ListNode;

/**
 * 从尾到头打印链表
 * @author sy
 *
 */
public class T5 {
     public static void printListReverse(ListNode head){
    	   Stack<Integer> s=new Stack<Integer>();
    	   ListNode dummy=head;
    	   while(dummy!=null){
    		   s.push(dummy.val);
    		   dummy=dummy.next;
    	   }
    	   while(!s.isEmpty()){
    		   System.out.print(s.pop()+" ");
    	   }
     }
     
     public static void main(String[] args){
    	  T5 t=new T5();
    	  ListNode[] nodes=new ListNode[5];
    	  for(int i=0;i<5;i++){
    		  nodes[i]=new ListNode(i+1);
    	  }
    	  for(int i=0;i<4;i++){
    		  nodes[i].next=nodes[i+1];
    	  }
    	  t.printListReverse(nodes[0]);
     }
}
