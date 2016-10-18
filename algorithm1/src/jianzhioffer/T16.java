package jianzhioffer;

import algorithm.ListNode;

public class T16 {
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode pre=null,next=null,cur=head;
        while(cur!=null){
        	next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
    
    public static void main(String[] args){
    	T16 r=new T16();
    	ListNode[] nodes=new ListNode[6];
    	for(int i=0;i<nodes.length;i++){
    		nodes[i]=new ListNode(i+1);
    	}
    	for(int i=0;i<nodes.length-1;i++){
    		nodes[i].next=nodes[i+1];
    	}
    	ListNode node=r.reverse(nodes[0]);
    	while(node!=null){
    		System.out.print(node.val);
    		node=node.next;
    	}
    }
}
